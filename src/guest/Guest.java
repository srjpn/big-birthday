package guest;

import guest.contact.MailingAddress;
import guest.specifics.*;

public class Guest {
    private final Name name;
    private final Gender gender;
    private final int age;
    private final Address address;

    public Guest(Name name, Gender gender, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public boolean isFromCity(String city){
        return address.getCity().equals(city);
    }

    public boolean isFromState(String state){
        return address.getState().equals(state);
    }

    public boolean isFromCountry(String country){
        return address.getCountry().equals(country);
    }

    public MailingAddress getMailAddress(){
        return new MailingAddress(this.name, this.gender, this.address);
    }
}

