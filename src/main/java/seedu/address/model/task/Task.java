package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class Task {
    private final Description description;
    private final Status status;

    /**
     * Every field must be present and not null.
     */
    public Task(Description description, Status status) {
        requireAllNonNull(description, status);
        this.description = description;
        this.status = status;
    }
    // Currently for v1.2, we assume that a task only has a description and a mark status
}
