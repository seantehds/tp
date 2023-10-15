package seedu.address.model.task;

/**
 * Represents the completion status of the task.
 * Guarantees: details are present and not null, immutable.
 */
public class Status {
    public final boolean isCompleted;

    /**
     * Constructs a {@code Status}.
     */
    public Status() {
        this.isCompleted = false;
    }

    /**
     * Constructs a {@code Status} with the specified completion status.
     */
    public Status(boolean newCompletionStatus) {
        this.isCompleted = newCompletionStatus;
    }

    /**
     * Update the completion status of the task assigned with this instance of Status.
     *
     * @return a new Status object with the updated completion status.
     */
    public Status updateStatus() {
        return new Status(!isCompleted);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Status)) {
            return false;
        }

        Status otherStatus = (Status) other;

        return this.isCompleted == otherStatus.isCompleted;
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        final String statusString = this.isCompleted ? "Completed" : "Incomplete";

        return '[' + statusString + ']';
    }

}
