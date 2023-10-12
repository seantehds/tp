package seedu.address.testutil;

import seedu.address.model.TaskWise;
import seedu.address.model.task.Task;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private TaskWise addressBook;

    public AddressBookBuilder() {
        addressBook = new TaskWise();
    }

    public AddressBookBuilder(TaskWise addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withPerson(Task person) {
        addressBook.addPerson(person);
        return this;
    }

    public TaskWise build() {
        return addressBook;
    }
}
