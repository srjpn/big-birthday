import bigBirthday.Cli;
import bigBirthday.guest.GuestParser;
import bigBirthday.printer.LabelPrinter;
import bigBirthday.People;
import bigBirthday.guest.filters.FilterAdder;
import bigBirthday.template.GuestTemplate;
import bigBirthday.template.MailTemplate;

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

            FilterAdder filterAdder = new FilterAdder(new Cli(args).getOptions());

            People filteredPeople = filterAdder.applyFilters(people).filter();

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
}
