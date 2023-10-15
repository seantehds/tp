package seedu.address.storage.exceptions.json;

/**
 * Represents an error whereby an illegal email was stored and referenced from the
 * JSON save file.
 */
public class IllegalJsonEmailValueException extends IllegalJsonValueException {
    public IllegalJsonEmailValueException(String message) {
        super(message);
    }
}
