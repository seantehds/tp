package seedu.address.testutil;

import seedu.address.model.TaskWise;
import seedu.address.model.task.Task;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code TaskWise ab = new TaskWiseBuilder().withTask("John", "Doe").build();}
 */
public class TaskWiseBuilder {

    private TaskWise addressBook;

    public TaskWiseBuilder() {
        addressBook = new TaskWise();
    }

    public TaskWiseBuilder(TaskWise addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Task} to the {@code TaskWise} that we are building.
     */
    public TaskWiseBuilder withTask(Task task) {
        addressBook.addTask(task);
        return this;
    }

    public TaskWise build() {
        return addressBook;
    }
}
