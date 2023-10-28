package seedu.address.model.tag;

/**
 * Represents a Member in taskwise.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Member extends Tag {

    public static final String MESSAGE_CONSTRAINTS = "Member names should be non-empty.";


    /**
     * Constructs a {@code Member}.
     *
     * @param memberName A valid member name.
     */
    public Member(String memberName) {
        super(memberName);
    }

    /**
     * Returns true if a given string is a valid member name.
     */
    public static boolean isValidName(String test) {
        return !(test.isEmpty());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Member)) {
            return false;
        }

        Member otherTag = (Member) other;
        return super.tagName.equals(otherTag.tagName);
    }

    @Override
    public int hashCode() {
        return super.tagName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + tagName + ']';
    }

}
