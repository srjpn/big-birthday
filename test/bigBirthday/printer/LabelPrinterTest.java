package bigBirthday.printer;

import bigBirthday.People;
import bigBirthday.guest.Guest;
import bigBirthday.guest.specifics.Address;
import bigBirthday.guest.specifics.Age;
import bigBirthday.guest.specifics.Gender;
import bigBirthday.guest.specifics.Name;
import bigBirthday.template.MailTemplate;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LabelPrinterTest {
    private Guest sooraj;
    private Guest shibi;

    @Before
    public void setUp() throws Exception {
        sooraj = new Guest(new Name("Sooraj","Parameswaran"), Gender.defineGenderAs("Male"), new Age(21), new Address("Thrissur","Kerala","India"));
        shibi = new Guest(new Name("Shibi","Reguvaran"),Gender.defineGenderAs("Female"),new Age(20),new Address("Thrissur","Kerala","India"));
    }

    @Test
    public void testPrint() throws Exception {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        People people = new People();
        people.add(shibi);
        people.add(sooraj);

        MailTemplate template = MailTemplate.createTemplate("first_name last_name");
        GuestPrinter printer = new LabelPrinter(template);
        printer.print(people);
        assertEquals("Shibi Reguvaran\n" +
                "Sooraj Parameswaran\n",outContent.toString());
    }
}