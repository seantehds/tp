package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.MEMBER_DESC_CHARLIE;
import static seedu.address.logic.commands.CommandTestUtil.MEMBER_DESC_DAVID;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.NAME_DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalTasks.AMY;

import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.AddCommand;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;
import seedu.address.testutil.TaskBuilder;

public class AddCommandParserTest {
    private AddCommandParser parser = new AddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        //TODO test will be fixed with PR merge with feature-add-command-for-deadline
        //Task expectedTask = new TaskBuilder(BOB).withMembers(VALID_MEMBER_CHARLIE).build();

        // whitespace only preamble
        //assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB
        //       + MEMBER_DESC_CHARLIE, new AddCommand(expectedTask));


        // multiple tags - all accepted
        //Task expectedTaskMultipleMembers = new TaskBuilder(BOB).withMembers(VALID_MEMBER_CHARLIE, VALID_MEMBER_DAVID)
        //        .build();
        //assertParseSuccess(parser,
        //        NAME_DESC_BOB + MEMBER_DESC_DAVID + MEMBER_DESC_CHARLIE,
        //        new AddCommand(expectedTaskMultipleMembers));
    }

    @Test
    public void parse_repeatedValue_failure() {
        String validExpectedTaskString = NAME_DESC_BOB + MEMBER_DESC_CHARLIE;

        // multiple names
        assertParseFailure(parser, NAME_DESC_AMY + validExpectedTaskString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DESCRIPTION));

        // multiple fields repeated
        assertParseFailure(parser,
                validExpectedTaskString + NAME_DESC_AMY + NAME_DESC_BOB
                        + validExpectedTaskString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DESCRIPTION));

        // invalid value followed by valid value

        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + validExpectedTaskString,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DESCRIPTION));

        // valid value followed by invalid value

        // invalid name
        assertParseFailure(parser, validExpectedTaskString + INVALID_NAME_DESC,
                Messages.getErrorMessageForDuplicatePrefixes(PREFIX_DESCRIPTION));
    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // zero members
        Task expectedTask = new TaskBuilder(AMY).withMembers().build();
        assertParseSuccess(parser, NAME_DESC_AMY,
                new AddCommand(expectedTask));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.COMMAND_WORD)
                + "\nUsage: " + AddCommand.MESSAGE_USAGE;

        // missing name prefix
        assertParseFailure(parser, VALID_NAME_BOB,
                expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_BOB,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC
                + MEMBER_DESC_DAVID + MEMBER_DESC_CHARLIE, Description.MESSAGE_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_NAME_DESC,
                Description.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_BOB
                + MEMBER_DESC_DAVID + MEMBER_DESC_CHARLIE,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.COMMAND_WORD)
                        + "\nUsage: " + AddCommand.MESSAGE_USAGE);
    }
}
