package bigBirthday.guest;

import bigBirthday.Guest;
import bigBirthday.specifics.Address;
import bigBirthday.specifics.Age;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class GuestTest {
    Guest guest;

    @Before
    public void setup() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        Gender gender = Gender.defineGenderAs("male");
        Address address = new Address("Thrissur", "Kerala", "India");
        Age age = new Age(21);

        guest = new Guest(name, gender, age, address);
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

    @Test
    public void testIsOlderThan_returns_true_if_the_person_is_older_than_the_given_age() throws Exception {
        assertTrue(guest.isOlderThan(15));
    }

    @Test
    public void testHashCode_returns_a_unique_code_generated_according_to_the_content() throws Exception {
        Name name = new Name("Sarath", "Sasindrakumar");
        Gender gender = Gender.defineGenderAs("male");
        Address address = new Address("Thrissur", "Kerala", "India");
        Age age = new Age(21);

        Guest person = new Guest(name, gender, age, address);

        assertEquals(-347206009,guest.hashCode());
        assertEquals(-1696492705,person.hashCode());
    }
}