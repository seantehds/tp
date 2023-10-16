package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Task in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    // Identity fields
    private final Description description;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();
    private final Status status;

    /**
     * Only description is required.
     * @param description
     */
    public Task(Description description) {
        requireAllNonNull(description);
        this.description = description;
        this.phone = new Phone("00000000");
        this.email = new Email("test@gmail.com");
        this.address = new Address("Remark for task");
        this.tags.addAll(Collections.emptySet());
        this.status = new Status();
    }

    /**
     * Constructor for task, to be used in retrieval from storage.
     *
     * @param description
     * @param status
     */
    public Task(Description description, Status status) {
        requireAllNonNull(description);
        this.description = description;
        this.status = status;
        this.phone = new Phone("00000000");
        this.email = new Email("test@gmail.com");
        this.address = new Address("Remark for task");
        this.tags.addAll(Collections.emptySet());
    }

    public Description getDescription() {
        return description;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public Status getStatus() {
        return status;
    }

    /**
     * Returns true if both tasks have the same name.
     * This defines a weaker notion of equality between two tasks.
     */
    public boolean isSameTask(Task otherTask) {
        if (otherTask == this) {
            return true;
        }

        return otherTask != null
                && otherTask.getDescription().equals(getDescription());
    }

    /**
     * Returns true if both tasks have the same identity and data fields.
     * This defines a stronger notion of equality between two tasks.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return description.equals(otherTask.description)
                && phone.equals(otherTask.phone)
                && email.equals(otherTask.email)
                && address.equals(otherTask.address)
                && tags.equals(otherTask.tags)
                && status.equals(otherTask.status);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(description, phone, email, address, tags, status);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", description)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("tags", tags)
                .add("status", status)
                .toString();
    }

}
