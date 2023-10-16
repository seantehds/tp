package seedu.address.storage.exceptions.storage;

/**
 * Represents an error during loading of data from a file.
 */
public class FileStorageLoadException extends Exception {
    public FileStorageLoadException(Exception cause) {
        super(cause);
    }

}
