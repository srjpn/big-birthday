package bigBirthday.guest;

import bigBirthday.specifics.Address;
import bigBirthday.specifics.Age;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;
import bigBirthday.template.MailTemplate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MailTemplateTest {

    @Test
    public void testCreateTemplate_creates_template_for_the_mailing_address_with_all_lower_case() throws Exception {
        MailTemplate mailTemplate = MailTemplate.createTemplate("tiTle. firSt_name Last_name\ncity, State\ncouNtry");
        assertEquals("title. first_name last_name\ncity, state\ncountry",mailTemplate.getTemplate());
    }

    @Test
    public void testGenerate_gives_the_address_in_specified_template() throws Exception {
        Name name = new Name("Sooraj", "Parameswaran");
        Gender gender = Gender.defineGenderAs("male");
        Address address = new Address("Thrissur", "Kerala", "India");
        Age age = new Age(20);

        MailTemplate mailTemplate = MailTemplate.createTemplate("tiTle. firSt_name last_name\ncity, State\ncouNtry");

        assertEquals("Mr. Sooraj Parameswaran\nThrissur, Kerala\nIndia",mailTemplate.generate(name,gender,address));
    }

}