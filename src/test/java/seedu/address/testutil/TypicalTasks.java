package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.TaskWise;
import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {
    // TODO: Change test cases
    public static final Task ALICE = new TaskBuilder().withDescription("Alice Pauline")
            .withTags("friends").build();
    public static final Task BENSON = new TaskBuilder().withDescription("Benson Meier")
            .withTags("owesMoney", "friends").build();
    public static final Task CARL = new TaskBuilder().withDescription("Carl Kurz").build();
    public static final Task DANIEL = new TaskBuilder().withDescription("Daniel Meier").withTags("friends").build();
    public static final Task ELLE = new TaskBuilder().withDescription("Elle Meyer").build();
    public static final Task FIONA = new TaskBuilder().withDescription("Fiona Kunz").build();
    public static final Task GEORGE = new TaskBuilder().withDescription("George Best").build();

    // Manually added
    public static final Task HOON = new TaskBuilder().withDescription("Hoon Meier").build();
    public static final Task IDA = new TaskBuilder().withDescription("Ida Mueller").build();

    // Manually added - Task's details found in {@code CommandTestUtil}
    // TODO: Add other fields required for test case ie. Deadline, Priority.
    public static final Task AMY = new TaskBuilder().withDescription(VALID_NAME_AMY).build();
    public static final Task BOB = new TaskBuilder().withDescription(VALID_NAME_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalTasks() {} // prevents instantiation

    /**
     * Returns an {@code TaskWise} with all the typical tasks.
     */
    public static TaskWise getTypicalTaskWise() {
        TaskWise ab = new TaskWise();
        for (Task task : getTypicalTasks()) {
            ab.addTask(task);
        }
        return ab;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
