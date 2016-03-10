package bigBirthday.guest;

import bigBirthday.People;
import bigBirthday.guest.specifics.Address;
import bigBirthday.guest.specifics.Age;
import bigBirthday.guest.specifics.Gender;
import bigBirthday.guest.specifics.Name;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GuestParserTest {
    private Guest sooraj;
    private Guest shibi;

    @Before
    public void setUp() throws Exception {
        sooraj = new Guest(new Name("Sooraj","Parameswaran"), Gender.defineGenderAs("Male"), new Age(21), new Address("Thrissur","Kerala","India"));
        shibi = new Guest(new Name("Shibi","Reguvaran"),Gender.defineGenderAs("Female"),new Age(20),new Address("Thrissur","Kerala","India"));
    }

    @Test
    public void testCreatePersonFromCSV() throws Exception {
        People result = new GuestParser("Sooraj,Parameswaran,Male,21,Thrissur,Kerala,India\n"+
                "Shibi,Reguvaran,Female,20,Thrissur,Kerala,India\n").createPersonFromCSV();

        for (Object person : result) {
            assertTrue(person.equals(sooraj) || person.equals(shibi));
        }
    }
}