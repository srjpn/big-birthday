import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by soorajp on 01/03/16.
 */
public class AddressTest {

    @Test
    public void testGetCity() throws Exception {
        Address address = new Address("Thrissur", "Kerala", "India");
        assertEquals("Thrissur", address.getCity());
    }

    @Test
    public void testGetState() throws Exception {
        Address address = new Address("Thrissur", "Kerala", "India");
        assertEquals("Kerala", address.getState());
    }

    @Test
    public void testGetCountry() throws Exception {
        Address address = new Address("Thrissur", "Kerala", "India");
        assertEquals("India", address.getCountry());
    }

    @Test
    public void testToString() throws Exception {
        Address address = new Address("Thrissur", "Kerala", "India");
        assertEquals("Thrissur Kerala\nIndia", address.toString());
    }
}