package bigBirthday.template;

import bigBirthday.specifics.Address;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;

public interface GuestTemplate {
    String generate(Name name, Gender gender, Address address);
}
