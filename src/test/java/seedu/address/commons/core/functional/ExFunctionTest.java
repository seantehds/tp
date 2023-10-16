package seedu.address.commons.core.functional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the {@code ExFunction} functional interface.
 */
public class ExFunctionTest {
    private static final ExFunction<Integer, Void, Exception> testFunction = x -> {
        throw new Exception("Test");
    };

    private static final ExFunction<Integer, Integer, Exception> testFunction2 = x -> x;

    @Test
    public void testFunction_valid_throwsException() throws Exception {
        assertThrows(Exception.class, () -> testFunction.apply(1));
    }

    @Test
    public void testFunction_valid_doesNotThrowException() throws Exception {
        assertDoesNotThrow(() -> testFunction2.apply(1));
    }

}
