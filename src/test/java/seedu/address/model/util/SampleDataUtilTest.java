package seedu.address.model.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SampleDataUtilTest {
    @Test
    public void getSampleTasks_valid() {
        assertDoesNotThrow(SampleDataUtil::getSampleTasks);
    }

    @Test
    public void getSampleTaskWise_valid() {
        assertDoesNotThrow(SampleDataUtil::getSampleTaskWise);
    }
}
