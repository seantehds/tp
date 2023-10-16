package seedu.address.commons.core.functional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

/**
 * Tests the {@code ExOptional} monad.
 */
public class ExOptionalTest {
    private static final ExOptional<Integer> somethingOptional = ExOptional.of(1);
    private static final ExOptional<Integer> nothingOptional = ExOptional.empty();
    private static final ExOptional<Integer> nullableOptional = ExOptional.ofNullable(null);
    private static final ExOptional<Integer> nullOptional = ExOptional.of(null);

    @Test
    public void get_somethingOptional_valid() {
        assertEquals(somethingOptional.get(), 1);
    }

    @Test
    public void get_nothingOptional_valid() {
        assertThrows(IllegalStateException.class, nothingOptional::get);
    }

    @Test
    public void get_nullableOptional_valid() {
        assertThrows(IllegalStateException.class, nullableOptional::get);
    }

    @Test
    public void get_nullOptional_valid() {
        assertNull(nullOptional.get());
    }

    @Test
    public void of_null_valid() {
        assertDoesNotThrow(() -> ExOptional.of(null));
    }


    @Test
    public void of_anything_valid2() {
        assertDoesNotThrow(() -> ExOptional.of(1));
    }

    @Test
    public void ofNullable_null_isEmpty() {
        assertTrue(ExOptional.ofNullable(null).isEmpty());
    }

    @Test
    public void ofNullable_anything_isEmpty() {
        ExOptional<Integer> iOp = ExOptional.ofNullable(1);
        assertFalse(iOp.isEmpty());
        assertTrue(iOp.isPresent());
    }

    @Test
    public void empty_valid() {
        assertTrue(ExOptional.empty().isEmpty());
    }

    @Test
    public void map_normalExecution_valid() {
        assertDoesNotThrow(() -> ExOptional.of(1).map(new ExFunction<Integer, Integer, Exception>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        }));
    }

    @Test
    public void map_normalValidValue_valid() throws Exception {
        ExOptional<Integer> iOp = ExOptional.of(1)
                .map((ExFunction<Integer, Integer, Exception>) integer -> integer + 1);

        assertEquals(iOp.get(), 2);
    }

    @Test
    public void map_normalThrowingFunction_invalid() {
        assertThrows(Exception.class, () -> ExOptional.of(1)
                .map((ExFunction<? super Integer, ?, Exception>) x -> {
                    throw new Exception();
                }));
    }

    @Test
    public void map_emptyExecution_valid() throws Exception {
        assertDoesNotThrow(() -> ExOptional.<Integer>empty().map(new ExFunction<Integer, Integer, Exception>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        }));
    }

    @Test
    public void map_emptyValidValue_valid() throws Exception {
        ExOptional<Integer> iOp = ExOptional.<Integer>empty()
                .map((ExFunction<Integer, Integer, Exception>) integer -> integer + 1);

        assertTrue(iOp.isEmpty());
    }

    @Test
    public void map_emptyThrowingFunction_valid() {
        assertDoesNotThrow(() -> ExOptional.<Integer>empty()
                .map((ExFunction<? super Integer, ?, Exception>) x -> {
                    throw new Exception();
                }));
    }

    @Test
    public void flatMap_normalExecution_valid() {
        assertDoesNotThrow(() -> ExOptional.of(1)
                .flatMap(new ExFunction<Integer, ExOptional<Integer>, Exception>() {
                    @Override
                    public ExOptional<Integer> apply(Integer integer) {
                        return ExOptional.of(2);
                    }
                }));
    }

    @Test
    public void flatMap_normalValidValue_valid() throws Exception {
        ExOptional<Integer> iOp = ExOptional.of(1)
                .flatMap((ExFunction<Integer, ExOptional<Integer>, Exception>) integer -> ExOptional.of(2));

        assertEquals(iOp.get(), 2);
    }

    @Test
    public void flatMap_normalThrowingFunction_invalid() {
        assertThrows(Exception.class, () -> ExOptional.of(1)
                .flatMap((ExFunction<Integer, ExOptional<Integer>, Exception>) x -> {
                    throw new Exception();
                }));
    }

    @Test
    public void flatMap_emptyExecution_valid() throws Exception {
        assertDoesNotThrow(() -> ExOptional.<Integer>empty().flatMap(
                new ExFunction<Integer, ExOptional<Integer>, Exception>() {
                    @Override
                    public ExOptional<Integer> apply(Integer integer) {
                        return ExOptional.of(2);
                    }
                }));
    }

    @Test
    public void flatMap_emptyValidValue_valid() throws Exception {
        ExOptional<Integer> iOp = ExOptional.of(1)
                .flatMap((ExFunction<Integer, ExOptional<Integer>, Exception>) integer -> ExOptional.of(2));

        assertEquals(iOp.get(), 2);
    }

    @Test
    public void flatMap_emptyThrowingFunction_invalid() {
        assertThrows(Exception.class, () -> ExOptional.of(1)
                .flatMap((ExFunction<Integer, ExOptional<Integer>, Exception>) x -> {
                    throw new Exception();
                }));
    }

    @Test
    public void filter_normalFilterSuccess_valid() {
        assertEquals(
                somethingOptional.filter(x -> x > 0).get(), 1
        );
    }

    @Test
    public void filter_normalFilterSuccessEmpty_valid() {
        assertTrue(somethingOptional.filter(x -> x < 0).isEmpty());
    }

    @Test
    public void filter_emptyFilterSuccess_valid() {
        assertTrue(nothingOptional.filter(Objects::isNull).isEmpty());
    }

    @Test
    public void filter_emptyFilterSuccessEmpty_valid() {
        assertTrue(nothingOptional.filter(Objects::nonNull).isEmpty());
    }

    @Test
    public void ifPresent_normalSuccess_valid() {
        final List<Integer> thing = new ArrayList<>();

        somethingOptional.ifPresent(y -> thing.add(1));

        assertEquals(thing.size(), 1);
        assertEquals(thing.get(0), 1);
    }

    @Test
    public void ifPresent_emptyFailure_valid() {
        final List<Integer> thing = new ArrayList<>();

        nothingOptional.ifPresent(y -> thing.add(1));

        assertEquals(thing.size(), 0);
    }

    @Test
    public void orElse_normalSuccess_valid() {
        assertEquals(somethingOptional.orElse(2), 1);
    }

    @Test
    public void orElse_emptySuccess_valid() {
        assertEquals(nothingOptional.orElse(2), 2);
    }

    @Test
    public void orElseGet_normalSuccess_valid() {
        assertEquals(somethingOptional.orElseGet(() -> 2), 1);
    }

    @Test
    public void orElseGet_emptySuccess_valid() {
        assertEquals(nothingOptional.orElseGet(() -> 2), 2);
    }
}
