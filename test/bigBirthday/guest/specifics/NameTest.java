package bigBirthday.guest.specifics;

import bigBirthday.specifics.Name;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NameTest {
    @Test
    public void testFirstNameFirst_gives_first_name_first_and_second_name_last() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        assertEquals("Sooraj Parameswaran", name.firstNameFirst());

    }

    @Test
    public void testSecondNameFirst_gives_second_name_first_and_first_name_last() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        assertEquals("Parameswaran Sooraj", name.secondNameFirst());
    }

    @Test
    public void testToString_gives_firstNameFirst() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        assertEquals("Sooraj Parameswaran", name.toString());
    }

}