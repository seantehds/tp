package seedu.address.model.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * Represents the Deadline of the task.
 * Guarantees: details are present and not null, immutable.
 */
public class Deadline implements Comparable<Deadline> {
    private static final Deadline NULL = new NullDeadline();

    public static final String MESSAGE_CONSTRAINTS =
            "Deadlines need to be in the format (DD(- OR /)MM(- OR /)YYYY HH(: or -)MM) "
                    + "OR (DD(- OR /)MM(- OR /)YYYY).";

    public static final String INVALID_DATE = "Please input a valid date/time!";

    //@@author asdfghjkxd-reused
    // Regex strings are reused with some modification from ChatGPT, and is also built and tested with
    // https://regex101.com/.
    /**
     * Regex for recognising DateTime inputs. The regex pattern below are adapted from ChatGPT,
     * modified to better meet the requirements of Juke.
     * <p>
     * <a href="https://regex101.com/">This</a> was used to build and test the new regex patterns.
     */
    public static final String DATETIME_REGEX = "^(0?[1-9]|[12][0-9]|3[01])(\\/|-)(0?[1-9]|1[0-2])(\\/|-)\\d{4} "
            + "([01]?[0-9]|2[0-3])?(-|:)?[0-5][0-9]$";

    /**
     * Regex for recognising Date inputs. The regex pattern below are adapted from ChatGPT,
     * modified to better meet the requirements of Juke.
     * <p>
     * <a href="https://regex101.com/">This</a> was used to build and test the new regex patterns.
     */
    public static final String DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])(\\/|-)(0?[1-9]|1[0-2])(\\/|-)\\d{4}";
    //@@ author
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final LocalDateTime details;

    /**
     * Constructs a {@code Deadline} with the current date and time.
     */
    public Deadline() {
        this.details = LocalDateTime.now();
    }

    /**
     * Constructs a {@code Deadline} with the current date and time.
     */
    public Deadline(LocalDateTime deadline) {
        this.details = deadline;
    }

    /**
     * Constructor to create a {@code NullDeadline} object.
     */
    public static Deadline noDeadline() {
        return Deadline.NULL;
    }

    //@@author asdfghjkxd-reused

    /**
     * Checks if the input date is of the correct Date format. A Date format is specified by only the date
     * and does not include the time.
     *
     * @param date Input date
     * @return true if the String is a valid Date format, else false
     */
    public static boolean isValidDate(String date) {
        return Pattern.matches(DATE_REGEX, date);
    }

    /**
     * Checks if the input date is of the correct DateTime format. A DateTime format specifies both the date
     * and the time.
     *
     * @param datetime Input datetime
     * @return true if the String is a valid DateTime format, else false
     */
    public static boolean isValidDateTime(String datetime) {
        return Pattern.matches(DATETIME_REGEX, datetime);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Deadline)) {
            return false;
        }

        Deadline otherStatus = (Deadline) other;

        return this.details.equals(otherStatus.details);
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return details.format(formatter);
    }

    @Override
    public int compareTo(Deadline o) {
        return this.details.compareTo(o.details);
    }

    private static final class NullDeadline extends Deadline {
        private NullDeadline() {
            super(LocalDateTime.MAX);
        }

        @Override
        public String toString() {
            return "No Deadline";
        }
    }
}
