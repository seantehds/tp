package seedu.address.storage.exceptions;

/**
 * Represents an exception whereby the user does not have sufficient
 * storage privilege to access a certain file system resource.
 */
public class InsufficientStoragePrivilegeException extends StorageException {
    public InsufficientStoragePrivilegeException(String message) {
        super(message);
    }

    public InsufficientStoragePrivilegeException(String message, Throwable cause) {
        super(message, cause);
    }
}
