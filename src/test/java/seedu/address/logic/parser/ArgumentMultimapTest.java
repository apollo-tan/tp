package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ArgumentMultimapTest {

    private static final Prefix PREFIX_POSTALCODE = new Prefix("postal/");
    private static final Prefix PREFIX_UNITNUMBER = new Prefix("unit/");

    @Test
    public void areOnlyPrefixesPresent_allSpecifiedPrefixesPresent_returnsTrue() {
        ArgumentMultimap argumentMultimap = new ArgumentMultimap();
        argumentMultimap.put(PREFIX_POSTALCODE, "123456");
        argumentMultimap.put(PREFIX_UNITNUMBER, "10");

        assertTrue(ArgumentMultimap.areOnlyPrefixesPresent(argumentMultimap, PREFIX_POSTALCODE, PREFIX_UNITNUMBER));
    }

    @Test
    public void areOnlyPrefixesPresent_oneMissingPrefix_returnsFalse() {
        ArgumentMultimap argumentMultimap = new ArgumentMultimap();
        argumentMultimap.put(PREFIX_POSTALCODE, "123456");

        assertFalse(ArgumentMultimap.areOnlyPrefixesPresent(argumentMultimap, PREFIX_POSTALCODE, PREFIX_UNITNUMBER));
    }

    @Test
    public void areOnlyPrefixesPresent_extraPrefixPresent_returnsFalse() {
        ArgumentMultimap argumentMultimap = new ArgumentMultimap();
        argumentMultimap.put(PREFIX_POSTALCODE, "123456");
        argumentMultimap.put(PREFIX_UNITNUMBER, "10");
        argumentMultimap.put(new Prefix("extra/"), "some value");

        assertFalse(ArgumentMultimap.areOnlyPrefixesPresent(argumentMultimap, PREFIX_POSTALCODE, PREFIX_UNITNUMBER));
    }

    @Test
    public void areOnlyPrefixesPresent_noPrefixesPresent_returnsFalse() {
        ArgumentMultimap argumentMultimap = new ArgumentMultimap();

        assertFalse(ArgumentMultimap.areOnlyPrefixesPresent(argumentMultimap, PREFIX_POSTALCODE, PREFIX_UNITNUMBER));
    }
}
