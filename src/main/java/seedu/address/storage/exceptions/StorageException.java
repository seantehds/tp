package seedu.address.storage.exceptions;

/**
 * Base exception class that signifies an error with storage-related operations.
 */
public class StorageException extends Exception {
    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
