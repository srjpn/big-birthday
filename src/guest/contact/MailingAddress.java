package guest.contact;

import guest.specifics.Address;
import guest.specifics.Gender;
import guest.specifics.Name;

public class MailingAddress {
    final Name name;
    final Gender gender;
    final Address address;

    public MailingAddress(Name name, Gender gender, Address address) {
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    @Override
    public String toString() {
        String initial = this.gender.getInitial();
        String name = this.name.toString();
        String address = this.address.toString();
        return initial+". "+name+"\n"+address;
    }
}
