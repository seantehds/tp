package seedu.address.model.task;

import java.time.LocalDateTime;


/**
 * Represents the completion status of the task.
 * Guarantees: details are present and not null, immutable.
 */
public class Deadline {
    private final LocalDateTime details;

    /**
     * Constructs a {@code Deadline} with the current date and time.
     */
    public Deadline() {
        this.details = LocalDateTime.now();
    }

    /**
     * Constructs a {@code Deadline} with the current date and time.
     */
    public Deadline(String wip) {
        this.details = LocalDateTime.of(2023, 10, 22, 18, 0);
    }

    public LocalDateTime getDetails() {
        return this.details;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Deadline)) {
            return false;
        }

        Deadline otherStatus = (Deadline) other;

        return this.details.equals(otherStatus.details);
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return details.toString();
    }

}
