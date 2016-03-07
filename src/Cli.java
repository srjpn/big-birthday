import org.apache.commons.cli.*;

public class Cli {
    private String[] args = null;
    private final Options options = new Options();
    private CommandLine parsedObj = null;

    public Cli(String[] args) {

        this.args = args;

        options.addOption("h", "help", false, "Show help");
        options.addOption("f", "FirstLast", false, "Shows first name first");
        options.addOption("l", "LastFirst", false, "Shows last name first");
        options.addOption("c", "city", false, "Filter by city");
        options.addOption("a", "age", false, "Filter by age");
    }

    private void parse() throws ParseException {
        CommandLineParser parser = new BasicParser();
        this.parsedObj = parser.parse(options, args);
    }

    public String getOptions() throws ParseException{
        this.parse();
        String result = "";
        Option[] options = parsedObj.getOptions();
        for (Option option : options) {
            result = result.concat(option.getOpt());
        }
        return  result;
    }

    public String[] getFiles() throws ParseException{
        this.parse();
        return this.parsedObj.getArgs();
    }

    public boolean hasOption(String a) throws ParseException{
        this.parse();
        return this.parsedObj.hasOption(a);
    }

    public void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Big_Birthday", options);
    }
}
