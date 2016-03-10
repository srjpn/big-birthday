package bigBirthday.guest.filters;

import bigBirthday.Guest;
import bigBirthday.filters.CountryFilter;
import bigBirthday.filters.Filter;
import bigBirthday.specifics.Address;
import bigBirthday.specifics.Age;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CountryFilterTest {

    @Test
    public void testFilter_returns_true_for_the_item_to_be_filtered() throws Exception {
        Guest richard = new Guest(new Name("Richard","Philip"), Gender.defineGenderAs("male"),new Age(46),new Address("Losa","WC","USA"));
        Filter filter = new CountryFilter("USA");

        assertTrue(filter.filter(richard));
    }

    @Test
    public void testFilter_returns_false_for_the_item_not_to_be_filtered() throws Exception {
        Guest richard = new Guest(new Name("Richard","Philip"), Gender.defineGenderAs("male"),new Age(46),new Address("Losa","WC","USA"));
        Filter filter = new CountryFilter("India");

        assertFalse(filter.filter(richard));
    }
}