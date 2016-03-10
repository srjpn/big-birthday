package bigBirthday.template;

import bigBirthday.guest.specifics.Address;
import bigBirthday.guest.specifics.Gender;
import bigBirthday.guest.specifics.Name;

public interface GuestTemplate {
    String generate(Name name, Gender gender, Address address);
}
