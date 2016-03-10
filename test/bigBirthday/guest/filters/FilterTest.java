package bigBirthday.guest.filters;

import bigBirthday.People;
import bigBirthday.guest.Guest;
import bigBirthday.guest.specifics.Address;
import bigBirthday.guest.specifics.Age;
import bigBirthday.guest.specifics.Gender;
import bigBirthday.guest.specifics.Name;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FilterTest {
    private Guest sooraj;
    private Guest shibi;

    @Before
    public void setUp() throws Exception {
        sooraj = new Guest(new Name("Sooraj","Parameswaran"), Gender.defineGenderAs("Male"), new Age(21), new Address("Thrissur","Kerala","India"));
        shibi = new Guest(new Name("Shibi","Reguvaran"),Gender.defineGenderAs("Female"),new Age(20),new Address("Thrissur","Kerala","India"));
    }

    @Test
    public void testFilter_filters_the_people_according_to_added_filtering_criteria() throws Exception {
        People people = new People();
        people.add(sooraj);
        people.add(shibi);

        Filter filter = new Filter();

        filter.addCriteria(new AgeFilterCriteria(21));


        People sortedPeople = filter.filter(people);

        People expected = new People();
        expected.add(sooraj);

        assertEquals(expected, sortedPeople);
    }
}