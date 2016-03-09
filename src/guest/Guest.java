package guest;

import guest.specifics.*;

public class Guest {
    private final Name name;
    private final Gender gender;
    private final Age age;
    private final Address address;

    public Guest(Name name, Gender gender, Age age, Address address) {
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

    protected String getInitial() {
        return gender.getInitial();
    }

    protected String getFirstName() {
        return name.getFirstName();
    }

    protected String getSecondName() {
        return name.getSecondName();
    }

    protected String getCity() {
        return address.getCity();
    }

    protected String getState() {
        return address.getState();
    }

    protected String getCountry() {
        return address.getCountry();
    }

    public boolean isOlderThan(int threshold){
        return this.age.isAgeAbove(threshold);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;

        Guest guest = (Guest) o;

        return name.equals(guest.name)
                && gender.equals(guest.gender)
                && age.equals(guest.age)
                && address.equals(guest.address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + address.hashCode();
        return result;
    }
}

