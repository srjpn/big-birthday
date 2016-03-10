package bigBirthday.guest.template;

import bigBirthday.template.BorderedTemplate;
import bigBirthday.specifics.Address;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorderedTemplateTest {

    @Test
    public void testGenerate() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        Gender gender = Gender.defineGenderAs("MALE");
        Address address = new Address("Thrissur","Kerala","India");

        BorderedTemplate template = new BorderedTemplate("+","-","|");

        String expected = "+-------------------------+\n" +
                          "| Mr. Sooraj Parameswaran |\n" +
                          "| Thrissur, Kerala        |\n" +
                          "| India                   |\n" +
                          "+-------------------------+\n";

        assertEquals(expected,template.generate(name, gender, address));
    }
}