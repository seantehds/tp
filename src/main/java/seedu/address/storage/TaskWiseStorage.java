package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyTaskWise;

/**
 * Represents a storage for {@link seedu.address.model.TaskWise}.
 */
public interface TaskWiseStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getTaskWiseFilePath();

    /**
     * Returns TaskWise data as a {@link ReadOnlyTaskWise}.
     * Returns {@code Optional.empty()} if storage file is not found.
     *
     * @throws DataLoadingException if loading the data from storage failed.
     */
    Optional<ReadOnlyAddressBook> readTaskWise() throws DataLoadingException;

    /**
     * @see #getTaskWiseFilePath()
     */
    Optional<ReadOnlyAddressBook> readTaskWise(Path filePath) throws DataLoadingException;

    /**
     * Saves the given {@link ReadOnlyTaskWise} to the storage.
     * @param taskWise cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveTaskWise(ReadOnlyAddressBook taskWise) throws IOException;

    /**
     * @see #saveTaskWise(ReadOnlyAddressBook)
     */
    void saveTaskWise(ReadOnlyAddressBook taskWise, Path filePath) throws IOException;

}
