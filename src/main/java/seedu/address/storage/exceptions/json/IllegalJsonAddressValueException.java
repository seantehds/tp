package seedu.address.storage.exceptions.json;

/**
 * Represents an error whereby an illegal address was stored and referenced from the
 * JSON save file.
 */
public class IllegalJsonAddressValueException extends IllegalJsonValueException {
    public IllegalJsonAddressValueException(String message) {
        super(message);
    }

    public IllegalJsonAddressValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
