package guest;

import org.junit.Before;
import org.junit.Test;
import guest.specifics.Address;
import guest.specifics.Gender;
import guest.specifics.Name;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GuestTest {
    Guest guest;

    @Before
    public void setup() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        Gender gender = Gender.defineGenderAs("male");
        Address address = new Address("Thrissur", "Kerala", "India");

        guest = new Guest(name, gender, 21, address);
    }

    @Test
    public void testGetMailAddress() throws Exception {
        assertEquals("Mr. Sooraj Parameswaran\nThrissur Kerala\nIndia", guest.getMailAddress().toString());
    }

    @Test
    public void testIsFromCity_returns_true_if_person_is_from_same_city() throws Exception {
        assertTrue(guest.isFromCity("Thrissur"));
    }

    @Test
    public void testIsFromState_returns_true_if_person_is_from_same_State() throws Exception {
        assertTrue(guest.isFromState("Kerala"));
    }

    @Test
    public void testIsFromCountry_returns_true_if_person_is_from_same_country() throws Exception {
        assertTrue(guest.isFromCountry("India"));
    }
}