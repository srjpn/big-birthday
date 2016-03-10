package bigBirthday.filters;

import bigBirthday.Guest;
import bigBirthday.People;
import bigBirthday.specifics.Address;
import bigBirthday.specifics.Age;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FilterAdderTest {
    private Guest sooraj;
    private Guest shibi;

    @Before
    public void setUp() throws Exception {
        sooraj = new Guest(new Name("Sooraj","Parameswaran"), Gender.defineGenderAs("Male"), new Age(21), new Address("Thrissur","Kerala","India"));
        shibi = new Guest(new Name("Shibi","Reguvaran"),Gender.defineGenderAs("Female"),new Age(20),new Address("Thrissur","Kerala","India"));
    }

    @Test
    public void testApplyFilters_applies_filters_and_returns_a_people_object_for_age() throws Exception {
        People people = new People();
        people.add(sooraj);
        people.add(shibi);

        HashMap<String,String> filters = new HashMap<>();
        filters.put("a","21");

        FilterAdder filterAdder = new FilterAdder(filters);

        People sortedPeople = filterAdder.applyFilters(people).filter();

        People expected = new People();
        expected.add(sooraj);

        assertEquals(expected, sortedPeople);
    }

    @Test
    public void testApplyFilters_applies_filters_and_returns_a_people_object_for_country() throws Exception {
        People people = new People();
        people.add(sooraj);
        people.add(shibi);

        HashMap<String,String> filters = new HashMap<>();
        filters.put("c","India");

        FilterAdder filterAdder = new FilterAdder(filters);

        People sortedPeople = filterAdder.applyFilters(people).filter();

        People expected = new People();
        expected.add(sooraj);
        expected.add(shibi);

        assertEquals(expected, sortedPeople);
    }
}