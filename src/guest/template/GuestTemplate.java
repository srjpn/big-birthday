package guest.template;

import guest.specifics.Address;
import guest.specifics.Gender;
import guest.specifics.Name;

public interface GuestTemplate {
    String generate(Name name, Gender gender, Address address);
}
