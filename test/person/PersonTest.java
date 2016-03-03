package person;

import org.junit.Before;
import org.junit.Test;
import person.specifics.Address;
import person.specifics.Gender;
import person.specifics.Name;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonTest {
    Person person;

    @Before
    public void setup() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        Gender gender = Gender.defineGenderAs("male");
        Address address = new Address("Thrissur", "Kerala", "India");

        person = new Person(name, gender, 21, address);
    }

    @Test
    public void testGetMailAddress() throws Exception {
        assertEquals("Mr. Sooraj Parameswaran\nThrissur Kerala\nIndia", person.getMailAddress().toString());
    }

    @Test
    public void testIsFromCity_returns_true_if_person_is_from_same_city() throws Exception {
        assertTrue(person.isFromCity("Thrissur"));
    }

    @Test
    public void testIsFromState_returns_true_if_person_is_from_same_State() throws Exception {
        assertTrue(person.isFromState("Kerala"));
    }

    @Test
    public void testIsFromCountry_returns_true_if_person_is_from_same_country() throws Exception {
        assertTrue(person.isFromCountry("India"));
    }
}