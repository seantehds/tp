package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_MEMBER_DAVID;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalTasks.FIX_BUG;
import static seedu.address.testutil.TypicalTasks.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TaskBuilder;

public class TaskTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Task task = new TaskBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> task.getMembers().remove(0));
    }

    @Test
    public void isSameTask() {
        // same object -> returns true
        assertTrue(FIX_BUG.isSameTask(FIX_BUG));

        // null -> returns false
        assertFalse(FIX_BUG.isSameTask(null));

        // same name, all other attributes different -> returns true
        Task editedFixBug = new TaskBuilder(FIX_BUG).withMembers(VALID_MEMBER_DAVID).build();
        assertTrue(FIX_BUG.isSameTask(editedFixBug));

        // different name, all other attributes same -> returns false
        editedFixBug = new TaskBuilder(FIX_BUG).withDescription(VALID_NAME_BOB).build();
        assertFalse(FIX_BUG.isSameTask(editedFixBug));

        // name differs in case, all other attributes same -> returns false
        Task editedBob = new TaskBuilder(BOB).withDescription(VALID_NAME_BOB.toLowerCase()).build();
        assertFalse(BOB.isSameTask(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
        editedBob = new TaskBuilder(BOB).withDescription(nameWithTrailingSpaces).build();
        assertFalse(BOB.isSameTask(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Task fixBugCopy = new TaskBuilder(FIX_BUG).build();
        assertTrue(FIX_BUG.equals(fixBugCopy));

        // same object -> returns true
        assertTrue(FIX_BUG.equals(FIX_BUG));

        // null -> returns false
        assertFalse(FIX_BUG.equals(null));

        // different type -> returns false
        assertFalse(FIX_BUG.equals(5));

        // different task -> returns false
        assertFalse(FIX_BUG.equals(BOB));

        // different name -> returns false
        Task editedAlice = new TaskBuilder(FIX_BUG).withDescription(VALID_NAME_BOB).build();
        assertFalse(FIX_BUG.equals(editedAlice));
    }

    @Test
    public void toStringMethod() {
        String expected = Task.class.getCanonicalName()
                + "{name=" + FIX_BUG.getDescription() + ", status=" + FIX_BUG.getStatus()
                + ", note=" + FIX_BUG.getNote() + ", deadline=" + FIX_BUG.getDeadline()
                + ", priority=" + FIX_BUG.getPriority() + ", members=" + FIX_BUG.getMembers() + "}";
        assertEquals(expected, FIX_BUG.toString());
    }
}
