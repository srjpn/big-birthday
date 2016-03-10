package bigBirthday.guest.filters;

import bigBirthday.guest.Guest;

public interface FilterCriteria {
    boolean isToBeFiltered(Guest guest);
}
