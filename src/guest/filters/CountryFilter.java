package guest.filters;

import guest.Guest;

public class CountryFilter implements Filter {
    private final String country;

    public CountryFilter(String country) {
        this.country = country;
    }

    @Override
    public boolean filter(Guest guest) {
        return guest.isFromCountry(country);
    }
}
