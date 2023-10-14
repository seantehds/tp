package seedu.address.storage.exceptions;

/**
 * Represents an error whereby the user cannot read or write to some system resource
 * for some reason.
 */
public class StorageReadWriteException extends StorageException {
    public StorageReadWriteException(String message) {
        super(message);
    }

    public StorageReadWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
