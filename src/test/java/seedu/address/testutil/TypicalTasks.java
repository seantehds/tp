package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.TaskWise;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {
    //Alice
    public static final Task FIX_BUG = new TaskBuilder()
            .withDescription("Fix bug").withStatus(false).withNote("").withPriority(Priority.NONE).build();
    //Benson
    public static final Task OP2_REPORT = new TaskBuilder()
            .withDescription("Do OP2 report").withStatus(false).withNote("").withPriority(Priority.NONE).build();
    //Carl
    public static final Task OP2_PRESENTATION = new TaskBuilder()
            .withDescription("Do OP2 presentation").withStatus(false).withNote("").withPriority(Priority.NONE).build();
    //Daniel
    public static final Task UG = new TaskBuilder()
            .withDescription("Do user guide").withStatus(false).withNote("").withPriority(Priority.NONE).build();
    //Elle
    public static final Task DG = new TaskBuilder()
            .withDescription("Do developer guide").withStatus(false).withNote("").withPriority(Priority.NONE).build();
    //Fiona
    public static final Task OP2_MEETING = new TaskBuilder()
            .withDescription("Meeting to discuss OP2").withStatus(false).withNote("")
            .withPriority(Priority.NONE).build();
    //George
    public static final Task OP2_REHEARSAL = new TaskBuilder()
            .withDescription("Rehearse OP2 presentation").withStatus(false).withNote("")
            .withPriority(Priority.NONE).build();


    // Manually added
    public static final Task TASK_ONE = new TaskBuilder().withDescription("task one").build();
    public static final Task TASK_TWO = new TaskBuilder().withDescription("task two").build();

    // Manually added - Task's details found in {@code CommandTestUtil}
    // TODO: Add other fields required for test case ie. Deadline, Priority.
    public static final Task AMY = new TaskBuilder()
            .withDescription(VALID_NAME_AMY).withStatus(false).withNote("").withPriority(Priority.NONE).build();
    public static final Task BOB = new TaskBuilder()
            .withDescription(VALID_NAME_BOB).withStatus(false).withNote("").withPriority(Priority.NONE).build();

    public static final String KEYWORD_MATCHING_MEIER = "OP2"; // A keyword that matches MEIER

    private TypicalTasks() {
    } // prevents instantiation

    /**
     * Returns an {@code TaskWise} with all the typical tasks.
     */
    public static TaskWise getTypicalTaskWise() {
        TaskWise tw = new TaskWise();
        for (Task task : getTypicalTasks()) {
            tw.addTask(task);
        }
        return tw;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(FIX_BUG, OP2_REPORT, OP2_PRESENTATION, UG, DG,
                OP2_MEETING, OP2_REHEARSAL));
    }
}
