package bigBirthday;

import bigBirthday.filters.AgeFilter;
import bigBirthday.filters.CountryFilter;
import bigBirthday.filters.Filter;
import bigBirthday.specifics.Address;
import bigBirthday.specifics.Age;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PeopleTest {
    People people;
    Guest richard;
    Guest lincon;
    Guest smrithi;

    @Before
    public void setup() throws Exception{
        richard = new Guest(new Name("Richard","Philip"), Gender.defineGenderAs("male"),new Age(46),new Address("Losa","WC","USA"));
        lincon = new Guest(new Name("Abraham","lincon"), Gender.defineGenderAs("male"),new Age(21),new Address("Mada","New York","USA"));
        smrithi = new Guest(new Name("Smrithi","Irani"), Gender.defineGenderAs("female"),new Age(37),new Address("Malapuram","Kerala","India"));

        people = new People();
        people.add(richard);
        people.add(lincon);
        people.add(smrithi);
    }

    @Test
    public void testFilterByCity() throws Exception {
        People fromCity = people.filterByCity("Malapuram");
        for (Guest person : fromCity) assertTrue(person.isFromCity("Malapuram"));
    }

    @Test
    public void testHashCode_returns_a_unique_number_according_to_content() throws Exception {
        assertEquals(-707999277, people.hashCode());
    }

    @Test
    public void testFilter_returns_a_collection_people_after_applying_preset_filters() throws Exception {
        Filter countryFilter = new CountryFilter("India");
        people.addFilter(countryFilter);

        People fromCountry = people.filter();
        for (Guest person : fromCountry) assertTrue(person.equals(smrithi));
    }

    @Test
    public void testFilter_returns_a_collection_people_after_applying_preset_multiple_filters() throws Exception {
        Filter countryFilter = new CountryFilter("USA");
        Filter ageFilter = new AgeFilter(37);
        people.addFilter(countryFilter);
        people.addFilter(ageFilter);

        People fromCountry = people.filter();
        for (Guest person : fromCountry) assertTrue(person.equals(richard));
    }
}