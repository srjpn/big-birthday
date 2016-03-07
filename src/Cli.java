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
        options.addOption("c", "country", true, "Filter by country");
        options.addOption("a", "age", true, "Filter by age");
    }

    private void parse() throws ParseException {
        CommandLineParser parser = new BasicParser();
        this.parsedObj = parser.parse(options, args);
    }

    public String getOptions() throws ParseException{
        if(null == parsedObj) this.parse();
        String result = "";
        Option[] options = parsedObj.getOptions();
        for (Option option : options) result = result.concat(option.getOpt());
        return  result;
    }

    public String getOptionValue(String option) throws ParseException {
        if(null == parsedObj) this.parse();
        return parsedObj.getOptionValue(option);
    }

    public String[] getFiles() throws ParseException{
        if(null == parsedObj) this.parse();
        return this.parsedObj.getArgs();
    }

    public boolean hasOption(String a) throws ParseException{
        if(null == parsedObj) this.parse();
        return this.parsedObj.hasOption(a);
    }

    public void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("BigBirthday", options);
    }
}
