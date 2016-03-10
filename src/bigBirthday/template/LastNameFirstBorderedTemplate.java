package bigBirthday.template;

import bigBirthday.specifics.Address;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;

import static java.lang.String.format;

public class LastNameFirstBorderedTemplate extends BorderedTemplate {

    public LastNameFirstBorderedTemplate(String corner, String upDown, String side) {
        super(corner, upDown, side);
    }

    @Override
    public String generate(Name name, Gender gender, Address address) {
        String firstLine = format("%s. %s, %s",gender.getInitial(),name.getSecondName(),name.getFirstName());
        String secondLine = format("%s, %s",address.getCity(),address.getState());
        String thirdLine = format("%s",address.getCountry());
        return generateBorder(firstLine, secondLine, thirdLine);
    }
}
