package seedu.address.logic.parser.exceptions;

public class InvalidFormatException extends ParseException {
    public InvalidFormatException(String message) {
        super(message);
    }

    public InvalidFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidFormatException(String message, String commandWord, String usageMessage) {
        super(String.format(message, commandWord) + "\nUsage: " + usageMessage);
    }

    public InvalidFormatException(String message, String commandWord, String usageMessage, Throwable cause) {
        super(String.format(message, commandWord) + "\nUsage: " + usageMessage, cause);
    }
}
