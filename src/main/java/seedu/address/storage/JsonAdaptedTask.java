package seedu.address.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.model.tag.Tag;
import seedu.address.model.task.Address;
import seedu.address.model.task.Description;
import seedu.address.model.task.Email;
import seedu.address.model.task.Phone;
import seedu.address.model.task.Status;
import seedu.address.model.task.Task;
import seedu.address.storage.exceptions.json.IllegalJsonAddressValueException;
import seedu.address.storage.exceptions.json.IllegalJsonDescriptionValueException;
import seedu.address.storage.exceptions.json.IllegalJsonEmailValueException;
import seedu.address.storage.exceptions.json.IllegalJsonNameValueException;
import seedu.address.storage.exceptions.json.IllegalJsonPhoneValueException;
import seedu.address.storage.exceptions.json.IllegalJsonValueException;

/**
 * Jackson-friendly version of {@link Task}.
 */
class JsonAdaptedTask {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Task's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String address;
    private final boolean status;
    private final List<JsonAdaptedTag> tags = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedTask} with the given task details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                           @JsonProperty("email") String email, @JsonProperty("address") String address,
                           @JsonProperty("tags") List<JsonAdaptedTag> tags, @JsonProperty("status") boolean status) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        if (tags != null) {
            this.tags.addAll(tags);
        }
        this.status = status;
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task source) {
        name = source.getDescription().fullDescription;
        phone = source.getPhone().value;
        email = source.getEmail().value;
        address = source.getAddress().value;
        tags.addAll(source.getTags().stream()
                .map(JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        status = source.getStatus().isCompleted;
    }

    /**
     * Converts this Jackson-friendly adapted task object into the model's {@code Task} object.
     *
     * @throws IllegalJsonValueException if there were any data constraints violated in the adapted task.
     */
    public Task toModelType() throws IllegalJsonValueException {
        final List<Tag> taskTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            taskTags.add(tag.toModelType());
        }


        if (name == null) {
            throw new IllegalJsonNameValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Description.class.getSimpleName()));
        }

        if (!Description.isValidDescription(name)) {
            throw new IllegalJsonDescriptionValueException(Description.MESSAGE_CONSTRAINTS);
        }

        final Description modelName = new Description(name);

        final Status modelStatus = new Status(status);

        if (phone == null) {
            throw new IllegalJsonValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalJsonPhoneValueException(Phone.MESSAGE_CONSTRAINTS);
        }

        if (email == null) {
            throw new IllegalJsonEmailValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Email.class.getSimpleName()));
        }
        if (!Email.isValidEmail(email)) {
            throw new IllegalJsonEmailValueException(Email.MESSAGE_CONSTRAINTS);
        }

        if (address == null) {
            throw new IllegalJsonAddressValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName()));
        }
        if (!Address.isValidAddress(address)) {
            throw new IllegalJsonAddressValueException(Address.MESSAGE_CONSTRAINTS);
        }

        return new Task(modelName, modelStatus);
    }

}
