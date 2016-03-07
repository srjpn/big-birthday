import guest.Guest;
import guest.contact.MailTemplate;

import java.util.ArrayList;

public class Big_Birthday {
    private static final String FILE = "data/records";
    private static final String MAILTEMPLATE = "data/template";

    public static void main(String[] args) throws Exception {

        String data =  ReadFile.addFile(FILE).getContent();
        String template =  ReadFile.addFile(MAILTEMPLATE).getContent();

        PersonCreator personCreator = new PersonCreator(data);
        ArrayList persons = personCreator.createPersonFromCSV();



        MailTemplate mailTemplate = MailTemplate.createTemplate(template);

        for (Object person1 : persons) {
            Guest guest = (Guest) person1;
            System.out.println(mailTemplate.generate(guest.getMailAddress()));
        }

    }
}
