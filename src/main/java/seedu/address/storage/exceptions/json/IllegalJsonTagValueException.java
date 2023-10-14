package seedu.address.storage.exceptions.json;

/**
 * Represents an error whereby an illegal tag name was stored and referenced from the
 * JSON save file.
 */
public class IllegalJsonTagValueException extends IllegalJsonValueException {
    public IllegalJsonTagValueException(String message) {
        super(message);
    }

    public IllegalJsonTagValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
