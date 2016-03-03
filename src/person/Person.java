package person;

import person.contact.MailingAddress;
import person.specifics.*;

public class Person {
    private final Name name;
    private final Gender gender;
    private final int age;
    private final Address address;

    public Person(Name name, Gender gender, int age, Address address) {
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

