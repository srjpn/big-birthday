import org.junit.Test;
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