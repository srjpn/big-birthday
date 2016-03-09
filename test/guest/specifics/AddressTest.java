package guest.specifics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


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

    @Test
    public void testEquals_returns_true_for_similar_objects() throws Exception {
        Address address = new Address("Thrissur","Kerala","India");
        Address anotherAddress = new Address("Thrissur","Kerala","India");

        assertTrue(address.equals(anotherAddress));
    }

    @Test
    public void testEquals_returns_for_for_similar_objects_with_different_values() throws Exception {
        Address address = new Address("Thrissur","Kerala","India");
        Address anotherAddress = new Address("Malapuram","Kerala","India");

        assertFalse(address.equals(anotherAddress));
    }

    @Test
    public void testHashCode_returns_a_unique_hashCode_generated_according_to_content() throws Exception {
        Address address = new Address("Thrissur","Kerala","India");
        assertEquals(1507620289,address.hashCode());
    }
}