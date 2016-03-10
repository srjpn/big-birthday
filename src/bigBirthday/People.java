package bigBirthday;

import bigBirthday.guest.Guest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class People implements Iterable<Guest>{
    private final Set<Guest> people;

    public People() {
        this.people = new HashSet<>();
    }

    public void add(Guest guest){
        this.people.add(guest);
    }

    @Override
    public Iterator<Guest> iterator() {
        return people.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People guests = (People) o;

        return people.equals(guests.people);

    }

    @Override
    public int hashCode() {
        return people.hashCode();
    }
}
