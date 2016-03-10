import guest.Guest;
import guest.template.MailTemplate;
import guest.specifics.Address;
import guest.specifics.Age;
import guest.specifics.Gender;
import guest.specifics.Name;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BigBirthdayTest {

    private BigBirthday birthday;
    private Guest sooraj;
    private Guest shibi;

    @Before
    public void setUp() throws Exception {
        birthday = new BigBirthday();
        sooraj = new Guest(new Name("Sooraj","Parameswaran"), Gender.defineGenderAs("Male"), new Age(21), new Address("Thrissur","Kerala","India"));
        shibi = new Guest(new Name("Shibi","Reguvaran"),Gender.defineGenderAs("Female"),new Age(20),new Address("Thrissur","Kerala","India"));
    }

    @Test
    public void testCreateGuest() throws Exception {
        Guest result = birthday.createGuest("Sooraj,Parameswaran,Male,21,Thrissur,Kerala,India");

        assertEquals(sooraj, result);
    }

    @Test
    public void testCreatePersonFromCSV() throws Exception {
        People result = birthday.createPersonFromCSV("Sooraj,Parameswaran,Male,21,Thrissur,Kerala,India\n"+
                                                     "Shibi,Reguvaran,Female,20,Thrissur,Kerala,India\n");

        for (Object person : result) {
            assertTrue(person.equals(sooraj) || person.equals(shibi));
        }
    }

    @Test
    public void testPrint() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        People people = new People();
        people.add(shibi);
        people.add(sooraj);

        MailTemplate template = MailTemplate.createTemplate("first_name last_name");

        birthday.print(template, people);
        assertEquals("Shibi Reguvaran\n" +
                "Sooraj Parameswaran\n",outContent.toString());
    }

    @Test
    public void testApplyFilters_applies_filters_and_returns_a_people_object_for_age() throws Exception {
        People people = new People();
        people.add(sooraj);
        people.add(shibi);

        HashMap<String,String> filters = new HashMap<>();
        filters.put("a","21");

        People sortedPeople = birthday.applyFilters(filters, people).filter();

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

        People sortedPeople = birthday.applyFilters(filters, people).filter();

        People expected = new People();
        expected.add(sooraj);
        expected.add(shibi);

        assertEquals(expected, sortedPeople);
    }
}