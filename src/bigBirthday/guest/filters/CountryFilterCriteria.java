package bigBirthday.guest.filters;

import bigBirthday.guest.Guest;

public class CountryFilterCriteria implements FilterCriteria {
    private final String country;

    public CountryFilterCriteria(String country) {
        this.country = country;
    }

    @Override
    public boolean isToBeFiltered(Guest guest) {
        return guest.isFromCountry(country);
    }
}
