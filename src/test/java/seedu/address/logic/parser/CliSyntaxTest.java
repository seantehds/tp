package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Checks that the relevant prefixes are present in the class
 */
public class CliSyntaxTest {
    @Test
    public void descriptionPrefix_exists() {
        assertNotNull(CliSyntax.PREFIX_DESCRIPTION);
        assertEquals(CliSyntax.PREFIX_DESCRIPTION.getPrefix(), "d/");
    }

    @Test
    public void tagDescription_exists() {
        assertNotNull(CliSyntax.PREFIX_TAG);
        assertEquals(CliSyntax.PREFIX_TAG.getPrefix(), "t/");
    }
}
