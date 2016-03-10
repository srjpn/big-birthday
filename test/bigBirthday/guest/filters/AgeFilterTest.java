package bigBirthday.guest.filters;

import bigBirthday.guest.Guest;
import bigBirthday.guest.specifics.Address;
import bigBirthday.guest.specifics.Age;
import bigBirthday.guest.specifics.Gender;
import bigBirthday.guest.specifics.Name;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AgeFilterTest {

    @Test
    public void testFilter_returns_true_for_the_item_to_be_filtered() throws Exception {
        Guest richard = new Guest(new Name("Richard","Philip"), Gender.defineGenderAs("male"),new Age(46),new Address("Losa","WC","USA"));
        Filter filter = new AgeFilter(18);

        assertTrue(filter.filter(richard));
    }

    @Test
    public void testFilter_returns_false_for_the_item_not_to_be_filtered() throws Exception {
        Guest richard = new Guest(new Name("Richard","Philip"), Gender.defineGenderAs("male"),new Age(46),new Address("Losa","WC","USA"));
        Filter filter = new AgeFilter(50);

        assertFalse(filter.filter(richard));
    }
}