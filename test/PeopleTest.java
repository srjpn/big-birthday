import guest.Guest;
import guest.specifics.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PeopleTest {
    People people;
    Guest richard;
    Guest lincon;
    Guest smrithi;

    @Before
    public void setup() throws Exception{
        richard = new Guest(new Name("Richard","Philip"), Gender.defineGenderAs("male"),46,new Address("Losa","WC","USA"));
        lincon = new Guest(new Name("Abraham","lincon"), Gender.defineGenderAs("male"),21,new Address("Mada","New York","USA"));
        smrithi = new Guest(new Name("Smrithi","Irani"), Gender.defineGenderAs("female"),37,new Address("Malapuram","Kerala","India"));

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
    public void testFilterByCountry() throws Exception {
        People fromCountry = people.filterByCountry("India");
        for (Guest person : fromCountry) assertTrue(person.isFromCountry("India"));
    }

    @Test
    public void testAboveAge_for_Age_as_int() throws Exception {
        People aboveAge = people.aboveAge(37);
        for (Guest person : aboveAge)
            assertTrue(person.isOlderThan(37));
    }

    @Test
    public void testAboveAge_for_Age_as_String() throws Exception {
        People aboveAge = people.aboveAge("37");
        for (Guest person : aboveAge)
            assertTrue(person.isOlderThan(37));

    }
}