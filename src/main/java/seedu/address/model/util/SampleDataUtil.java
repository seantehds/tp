package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.TaskWise;
import seedu.address.model.ReadOnlyTaskWise;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Task[] getSamplePersons() {
        return new Task[] {
            new Task(new Description("Project meeting")),
            new Task(new Description("User guide")),
            new Task(new Description("Developer guide"))
        };
    }

    public static ReadOnlyTaskWise getSampleAddressBook() {
        TaskWise sampleAb = new TaskWise();
        for (Task samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
