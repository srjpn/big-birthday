import org.junit.Test;
import person.contact.MailingAddress;
import person.specifics.Address;
import person.specifics.Gender;
import person.specifics.Name;

import static org.junit.Assert.assertEquals;

public class MailingAddressTest {

    @Test
    public void testToString() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        Gender gender = Gender.defineGenderAs("male");
        Address address = new Address("Thrissur", "Kerala", "India");

        MailingAddress mailingAddress = new MailingAddress(name, gender, address);

        assertEquals("Mr. Sooraj Parameswaran\nThrissur Kerala\nIndia", mailingAddress.toString());
    }
}