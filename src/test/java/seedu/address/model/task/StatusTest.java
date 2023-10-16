package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class StatusTest {

    @Test
    public void updateStatus() {
        final Status status = new Status();

        //initial status is false, incomplete
        assertFalse(status.isCompleted());

        final Status updatedStatus = status.updateStatus();

        //updated status is true, completed
        assertTrue(updatedStatus.isCompleted());

        final Status revertStatus = updatedStatus.updateStatus();

        //reverted status back to false, incomplete
        assertFalse(revertStatus.isCompleted());
    }

    @Test
    public void equals() {
        final Status status = new Status();

        //Same object -> returns true
        assertTrue(status.equals(status));

        //null -> returns false
        assertFalse(status.equals(null));

        //Different types -> returns false
        assertFalse(status.equals(123));

        //Different completion status -> returns false
        assertFalse(status.equals(status.updateStatus()));
    }

    @Test
    public void stringFormat() {
        final Status status = new Status();

        assertTrue(status.toString().equals("[Incomplete]"));

        final Status updatedStatus = status.updateStatus();

        assertTrue(updatedStatus.toString().equals("[Completed]"));

    }
}
