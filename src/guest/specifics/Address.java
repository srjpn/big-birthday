package guest.specifics;

public class Address {
    private final String city, state, country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return this.city+" "+this.state+"\n"+this.country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        return city.equals(address.city)
                && state.equals(address.state)
                && country.equals(address.country);
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }
}
