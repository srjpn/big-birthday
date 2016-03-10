package bigBirthday.guest.filters;

import bigBirthday.People;
import org.apache.commons.cli.ParseException;

import java.util.HashMap;
import java.util.Set;

public class FilterAdder {
    HashMap filters;

    public FilterAdder(HashMap filters) {
        this.filters = filters;
    }

    public People applyFilters(People collection) throws ParseException {
        Set commands = filters.keySet();
        for (Object command1 : commands) {
            String command = (String) command1;
            switch (command) {
                case "c":
                    String country = (String) filters.get(command);
                    collection.addFilter(new CountryFilter(country));
                    break;
                case "a":
                    int age = Integer.parseInt((String) filters.get(command));
                    collection.addFilter(new AgeFilter(age));
                    break;
            }
        }
        return collection;
    }
}
