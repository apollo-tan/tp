package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid.
 */
public class Remark {

    /** The content of the remark associated with a person */
    public final String value;

    /**
     * Constructs a {@code Remark}.
     *
     * @param remark A valid remark.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    /**
     * Returns the string representation of the remark.
     *
     * @return The remark as a string.
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Compares this remark with another object for equality.
     *
     * @param other The object to compare with.
     * @return true if the other object is a {@code Remark} and has the same value.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    /**
     * Returns the hash code for this remark.
     *
     * @return The hash code of the remark's value.
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
