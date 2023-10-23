package seedu.address.logic.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import seedu.address.logic.sort.enums.SortOrderEnum;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;

public class SortUtilTest {
    private final Comparator<Task> taskComparatorAscending = SortUtil.ofTaskName(SortOrderEnum.ASCENDING);
    private final Comparator<Task> taskComparatorDescending = SortUtil.ofTaskName(SortOrderEnum.DESCENDING);
    private final Comparator<Task> priorityComparatorAscending = SortUtil.ofPriority(SortOrderEnum.ASCENDING);
    private final Comparator<Task> priorityComparatorDescending = SortUtil.ofPriority(SortOrderEnum.DESCENDING);
    private final Comparator<Task> deadlineComparatorAscending = SortUtil.ofDeadline(SortOrderEnum.ASCENDING);
    private final Comparator<Task> deadlineComparatorDescending = SortUtil.ofDeadline(SortOrderEnum.DESCENDING);

    @Test
    public void ofTaskName_ascendingLessThan_valid() {
        Task t1 = new Task(new Description("a"));
        Task t2 = new Task(new Description("b"));
        assertEquals(taskComparatorAscending.compare(t1, t2), -1);
    }

    @Test
    public void ofTaskName_ascendingEqual_valid() {
        Task t1 = new Task(new Description("a"));
        Task t2 = new Task(new Description("a"));
        assertEquals(taskComparatorAscending.compare(t1, t2), 0);
    }

    @Test
    public void ofTaskName_ascendingMoreThan_valid() {
        Task t1 = new Task(new Description("b"));
        Task t2 = new Task(new Description("a"));
        assertEquals(taskComparatorAscending.compare(t1, t2), 1);
    }

    @Test
    public void ofTaskName_ascending_invalid() {
        assertThrows(AssertionError.class, () -> taskComparatorAscending.compare(null, null));
    }

    @Test
    public void ofTaskName_descendingLessThan_valid() {
        Task t1 = new Task(new Description("a"));
        Task t2 = new Task(new Description("b"));
        assertEquals(taskComparatorDescending.compare(t1, t2), 1);
    }

    @Test
    public void ofTaskName_descendingEqual_valid() {
        Task t1 = new Task(new Description("a"));
        Task t2 = new Task(new Description("a"));
        assertEquals(taskComparatorDescending.compare(t1, t2), 0);
    }

    @Test
    public void ofTaskName_descendingMoreThan_valid() {
        Task t1 = new Task(new Description("b"));
        Task t2 = new Task(new Description("a"));
        assertEquals(taskComparatorDescending.compare(t1, t2), -1);
    }

    @Test
    public void ofTaskName_descending_invalid() {
        assertThrows(AssertionError.class, () -> taskComparatorDescending.compare(null, null));
    }

    @Test
    public void ofPriority_ascendingLessThan_valid() {

    }

    @Test
    public void ofPriority_ascendingEqual_valid() {

    }

    @Test
    public void ofPriority_ascendingMoreThan_valid() {

    }

    @Test
    public void ofPriority_ascending_invalid() {
        assertThrows(AssertionError.class, () -> priorityComparatorAscending.compare(null, null));
    }

    @Test
    public void ofPriority_descendingLessThan_valid() {

    }

    @Test
    public void ofPriority_descendingEqual_valid() {

    }

    @Test
    public void ofPriority_descendingMoreThan_valid() {

    }

    @Test
    public void ofPriority_descending_invalid() {
        assertThrows(AssertionError.class, () -> priorityComparatorDescending.compare(null, null));
    }

    @Test
    public void ofDeadline_ascendingLessThan_valid() {

    }

    @Test
    public void ofDeadline_ascendingEqual_valid() {

    }

    @Test
    public void ofDeadline_ascendingMoreThan_valid() {

    }

    @Test
    public void ofDeadline_ascending_invalid() {
        assertThrows(AssertionError.class, () -> deadlineComparatorAscending.compare(null, null));
    }

    @Test
    public void ofDeadline_descendingLessThan_valid() {

    }

    @Test
    public void ofDeadline_descendingEqual_valid() {

    }

    @Test
    public void ofDeadline_descendingMoreThan_valid() {

    }

    @Test
    public void ofDeadline_descending_invalid() {
        assertThrows(AssertionError.class, () -> deadlineComparatorDescending.compare(null, null));
    }
}
