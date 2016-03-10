package bigBirthday;

import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.*;

public class CliTest {
    @Test
    public void it_parses_the_commads_and_says_yes_of_no_for_asked_commad_is_present_or_not() throws ParseException{
        String[] sampleArg = {"-c","Bangladesh"};
        Cli sample = new Cli(sampleArg);
        assertTrue(sample.hasOption("c"));
    }

    @Test
    public void cli_says_no_for_asked_command_is_not_present() throws ParseException{
        String[] sampleArg = {"-c","sample.txt"};
        Cli sample = new Cli(sampleArg);
        assertFalse(sample.hasOption("w"));
    }

    @Test
    public void cli_gives_the_value_argument_given_for_the_command() throws ParseException{
        String[] sampleArg = {"-c","Malapuram","sample.txt"};
        Cli sample = new Cli(sampleArg);
        assertEquals("Malapuram",sample.getOptionValue("c"));
    }

    @Test
    public void it_treats_all_the_non_commads_as_files() throws ParseException{
        String[] sampleArg = {"-c","Bangladesh","sample.txt"};
        Cli sample = new Cli(sampleArg);
        String[] files = {"sample.txt"};
        assertArrayEquals(files,sample.getFiles());
    }

    @Test
    public void it_throws_exception_for_unvaild_commads() throws ParseException {
        String[] sampleArg = {"-d","sample.txt"};
        Cli sample = new Cli(sampleArg);
        try{
            sample.getFiles();
        }
        catch (UnrecognizedOptionException e) {
            assertEquals(e.getMessage(), "Unrecognized option: -d");
        }
    }

    @Test
    public void it_gives_a_string_of_all_sample() throws ParseException {
        String[] sampleArgs = {"-a","18","-c","Bangladesh"};
        Cli sample = new Cli(sampleArgs);

        HashMap<String,String> expected = new HashMap<>();
        expected.put("a","18");
        expected.put("c","Bangladesh");

        assertEquals(expected,sample.getOptions());
    }

    @Test
    public void it_prints_formatted_help_text() throws ParseException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String[] sampleArgs = {"-w","-c","Bangladesh"};
        Cli sample = new Cli(sampleArgs);
        sample.help();
        assertEquals("usage: BigBirthday\n" +
                " -a,--age <arg>       FilterCriteria by age\n" +
                " -c,--country <arg>   FilterCriteria by country\n" +
                " -h,--help            Show help\n",outContent.toString());
    }
}
