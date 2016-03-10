import bigBirthday.Cli;
import bigBirthday.People;
import bigBirthday.guest.GuestParser;
import bigBirthday.guest.filters.AgeFilterCriteria;
import bigBirthday.guest.filters.CountryFilterCriteria;
import bigBirthday.guest.filters.Filter;
import bigBirthday.printer.LabelPrinter;
import bigBirthday.template.GuestTemplate;
import bigBirthday.template.MailTemplate;

import java.util.HashMap;
import java.util.Set;

public class BigBirthday {
    private static final String FILE = "data/records";

    public static void main(String[] args) {
        Cli arguments = new Cli(args);
        try{
            String data =  ReadFile.addFile(FILE).getContent();

            if (arguments.hasOption("h")){
                arguments.help();
                return;
            }

            People people = new GuestParser(data).createPersonFromCSV();

            GuestTemplate template = MailTemplate.createTemplate("TITLE. FIRST_NAME LAST_NAME\nCITY, STATE, COUNTRY\n");

            Filter filter = new Filter();

            addFilters(arguments.getOptions(), filter);

            People filteredPeople = filter.filter(people);

            new LabelPrinter(template).print(filteredPeople);
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

    private static void addFilters(HashMap<String, String> options, Filter filter) {
        Set<String> commands = options.keySet();
        for (String command : commands) {
            switch (command) {
                case "c":
                    String country = options.get(command);
                    filter.addCriteria(new CountryFilterCriteria(country));
                    break;
                case "a":
                    int age = Integer.parseInt(options.get(command));
                    filter.addCriteria(new AgeFilterCriteria(age));
                    break;
            }
        }
    }
}
