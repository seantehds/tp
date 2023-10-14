package seedu.address.storage.exceptions.json;

/**
 * Represents an error whereby an illegal phone number was stored and referenced from the
 * JSON save file.
 */
public class IllegalJsonPhoneValueException extends IllegalJsonValueException {
    public IllegalJsonPhoneValueException(String message) {
        super(message);
    }

    public IllegalJsonPhoneValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
