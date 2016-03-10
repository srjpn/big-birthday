package bigBirthday;

import bigBirthday.guest.Guest;
import bigBirthday.guest.specifics.Address;
import bigBirthday.guest.specifics.Age;
import bigBirthday.guest.specifics.Gender;
import bigBirthday.guest.specifics.Name;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
    public void testHashCode_returns_a_unique_number_according_to_content() throws Exception {
        assertEquals(-715575347, people.hashCode());
    }
}