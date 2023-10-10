package seedu.address.model.task.exceptions;

public class DuplicateTaskException extends RuntimeException {
    /**
     * Signals that the operation will result in duplicate Tasks (Tasks are considered duplicates if they have the same
     * description).
     */
    public DuplicateTaskException() {
        super("Operation would result in duplicate tasks");
    }
}
