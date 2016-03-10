package bigBirthday.guest.filters;

import bigBirthday.guest.Guest;

public class AgeFilterCriteria implements FilterCriteria {
    int age;

    public AgeFilterCriteria(int age) {
        this.age = age;
    }

    @Override
    public boolean isToBeFiltered(Guest guest) {
        return guest.isOlderThan(age);
    }
}
