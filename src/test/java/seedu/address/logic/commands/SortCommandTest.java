package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.sort.enums.SortOrderEnum;
import seedu.address.logic.sort.enums.SortTypeEnum;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyTaskWise;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;
import seedu.address.model.task.UniqueTaskList;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class SortCommandTest {
    private static final SortCommand validTaskNameAsc = new SortCommand(SortOrderEnum.ASCENDING,
            SortTypeEnum.TASK_NAME);
    private static final SortCommand validTaskNameDes = new SortCommand(SortOrderEnum.DESCENDING,
            SortTypeEnum.TASK_NAME);
    private static final SortCommand validPriorityAsc = new SortCommand(SortOrderEnum.ASCENDING,
            SortTypeEnum.PRIORITY);
    private static final SortCommand validPriorityDes = new SortCommand(SortOrderEnum.DESCENDING,
            SortTypeEnum.PRIORITY);
    private static final SortCommand validDeadlineAsc = new SortCommand(SortOrderEnum.ASCENDING, SortTypeEnum.DEADLINE);
    private static final SortCommand validDeadlineDes = new SortCommand(SortOrderEnum.DESCENDING, SortTypeEnum.DEADLINE);

    @Test
    public void constructor_nullTasks_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> new SortCommand(null, null));
    }

    @Test
    public void execute_allTasksSetInModel_success() {
        ModelStubWithTaskAccess modelStub = new ModelStubWithTaskAccess();
        assertTrue(modelStub.isSorted(
                List.of(new Task(new Description("oh no")),
                        new Task(new Description("an apple")),
                        new Task(new Description("xylophone")))
        ));
    }

    @Test
    public void execute_sortByTaskNameAscending_success() {
        SortCommandTest.ModelStubWithTaskAccess modelStub = new ModelStubWithTaskAccess();
        assertDoesNotThrow(() -> SortCommandTest.validTaskNameAsc.execute(modelStub));
        assertTrue(modelStub.isSorted(
                List.of(new Task(new Description("an apple")),
                        new Task(new Description("oh no")),
                        new Task(new Description("xylophone")))
        ));
    }

    @Test
    public void execute_sortByTaskNameDescending_success() {
        SortCommandTest.ModelStubWithTaskAccess modelStub = new ModelStubWithTaskAccess();
        assertDoesNotThrow(() -> SortCommandTest.validTaskNameDes.execute(modelStub));
        assertTrue(modelStub.isSorted(
                List.of(new Task(new Description("xylophone")),
                        new Task(new Description("oh no")),
                        new Task(new Description("an apple")))
        ));
    }



    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(validTaskNameAsc.equals(validTaskNameAsc));

        // same values -> returns true
        assertTrue(validTaskNameAsc.equals(new SortCommand(SortOrderEnum.ASCENDING, SortTypeEnum.TASK_NAME)));

        // different types -> returns false
        assertFalse(validTaskNameAsc.equals(true));

        // null -> returns false
        assertFalse(validTaskNameAsc.equals(null));

        // different task -> returns false
        assertFalse(validDeadlineDes.equals(validPriorityDes));
    }

    @Test
    public void toString_convertToString_success() {
        String expected = SortCommand.class.getCanonicalName() + "{order=" + SortOrderEnum.ASCENDING + ", "
                + "type=" + SortTypeEnum.DEADLINE + "}";
        assertEquals(expected, SortCommandTest.validDeadlineAsc.toString());
    }

    /**
     * A default model stub that have all the methods failing.
     */
    private static class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getTaskWiseFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTaskWiseFilePath(Path taskWiseFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTaskWise(ReadOnlyTaskWise newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyTaskWise getTaskWise() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTask(Task target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTask(Task target, Task editedTask) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAllTasks(List<Task> tasks) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getFilteredTaskList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredTaskList(Predicate<Task> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single task.
     */
    private static class ModelStubWithTaskAccess extends SortCommandTest.ModelStub {
        private final List<Task> innerList = new LinkedList<>();

        ModelStubWithTaskAccess() {
            this.addTask(new Task(new Description("oh no")));
            this.addTask(new Task(new Description("an apple")));
            this.addTask(new Task(new Description("xylophone")));
        }

        @Override
        public void addTask(Task task) {
            this.innerList.add(task);
        }

        @Override
        public void setAllTasks(List<Task> tasks) {
            this.innerList.clear();
            this.innerList.addAll(tasks);
        }

        @Override
        public ObservableList<Task> getFilteredTaskList() {
            UniqueTaskList tl = new UniqueTaskList();
            tl.setTasks(this.innerList);
            return tl.asUnmodifiableObservableList();
        }

        public boolean isSorted(List<Task> expected) {
            return this.innerList.equals(expected);
        }
    }
}
