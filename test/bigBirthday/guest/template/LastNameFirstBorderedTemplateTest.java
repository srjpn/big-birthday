package bigBirthday.guest.template;

import bigBirthday.template.BorderedTemplate;
import bigBirthday.template.LastNameFirstBorderedTemplate;
import bigBirthday.specifics.Address;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LastNameFirstBorderedTemplateTest {

    @Test
    public void testGenerate() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        Gender gender = Gender.defineGenderAs("MALE");
        Address address = new Address("Thrissur","Kerala","India");

        BorderedTemplate template = new LastNameFirstBorderedTemplate("+","-","|");

        String expected = "+--------------------------+\n" +
                          "| Mr. Parameswaran, Sooraj |\n" +
                          "| Thrissur, Kerala         |\n" +
                          "| India                    |\n" +
                          "+--------------------------+\n";

        assertEquals(expected,template.generate(name, gender, address));
    }
}