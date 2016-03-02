import org.junit.Test;
import person.Person;
import person.specifics.Address;
import person.specifics.Gender;
import person.specifics.Name;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void testGetMailAddress() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        Gender gender = Gender.defineGenderAs("male");
        Address address = new Address("Thrissur", "Kerala", "India");

        Person person = new Person(name, gender, 21, address);

        assertEquals("Mr. Sooraj Parameswaran\nThrissur Kerala\nIndia", person.getMailAddress().toString());
    }
}