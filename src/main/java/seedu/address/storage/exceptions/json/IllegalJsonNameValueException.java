package seedu.address.storage.exceptions.json;

/**
 * Represents an error whereby an illegal name was stored and referenced from the
 * JSON save file.
 */
public class IllegalJsonNameValueException extends IllegalJsonValueException {
    public IllegalJsonNameValueException(String message) {
        super(message);
    }

    public IllegalJsonNameValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
