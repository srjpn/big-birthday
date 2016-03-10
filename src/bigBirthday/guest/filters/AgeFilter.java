package bigBirthday.guest.filters;

import bigBirthday.guest.Guest;

public class AgeFilter implements Filter {
    int age;

    public AgeFilter(int age) {
        this.age = age;
    }

    @Override
    public boolean filter(Guest guest) {
        return guest.isOlderThan(age);
    }
}
