import guest.Guest;
import guest.contact.MailTemplate;
import guest.specifics.Address;
import guest.specifics.Gender;
import guest.specifics.Name;

import java.util.ArrayList;

public class Big_Birthday {
    private static final String FILE = "data/records";
    private static final String MAILTEMPLATE = "data/template";

    public static void main(String[] args) throws Exception {

        String data =  ReadFile.addFile(FILE).getContent();
        String template =  ReadFile.addFile(MAILTEMPLATE).getContent();

        ArrayList persons = createPersonFromCSV(data);



        MailTemplate mailTemplate = MailTemplate.createTemplate(template);

        for (Object person1 : persons) {
            Guest guest = (Guest) person1;
            System.out.println(mailTemplate.generate(guest));
        }

    }

    public static ArrayList<Guest> createPersonFromCSV(String data) throws Exception {
        String[] csvData = data.split("\n");
        ArrayList<Guest> guests = new ArrayList<>(10);

        for (String personData : csvData) {
            String[] personDetails = personData.split(",");
            Name name = new Name(personDetails[0],personDetails[1]);
            Gender gender = Gender.defineGenderAs(personDetails[2]);
            Integer age = Integer.parseUnsignedInt(personDetails[3]);
            Address address = new Address(personDetails[4],personDetails[5],personDetails[6]);
            Guest guest = new Guest(name, gender, age, address);
            guests.add(guest);
        }
        return guests;
    }
}
