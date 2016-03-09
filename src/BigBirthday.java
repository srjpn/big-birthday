import guest.Guest;
import guest.MailTemplate;
import guest.specifics.Address;
import guest.specifics.Gender;
import guest.specifics.Name;

public class BigBirthday {
    private static final String FILE = "data/records";
    private static final String MAILTEMPLATE = "data/template";

    public static void main(String[] args) {
        Cli arguments = new Cli(args);

        try{
            String data =  ReadFile.addFile(FILE).getContent();
            String template =  ReadFile.addFile(MAILTEMPLATE).getContent();

            if (arguments.hasOption("h")){
                arguments.help();
                return;
            }

            People people = createPersonFromCSV(data);

            String commands = new Cli(args).getOptions();

            MailTemplate mailTemplate = MailTemplate.createTemplate(template);

            for (int i = 0; i < commands.length(); i++) {
                String command = String.valueOf(commands.charAt(i));
                switch (command) {
                    case "c":
                        people = people.filterByCountry(arguments.getOptionValue(command));
                        break;
                    case "a":
                        people = people.aboveAge(arguments.getOptionValue(command));
                        break;
                }
            }

            print(mailTemplate, people);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            arguments.help();
            System.exit(1);
        }
        catch (Error e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    private static People createPersonFromCSV(String data) throws Exception, Error {
        String[] csvData = data.split("\n");
        People guests = new People();

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

    private static void print(MailTemplate template, People people){
        for (Guest guest : people) {
            System.out.println(template.generate(guest));
        }
    }
}
