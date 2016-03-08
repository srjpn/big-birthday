import guest.Guest;

import java.util.ArrayList;
import java.util.Iterator;

public class People implements Iterable<Guest>{
    private final ArrayList<Guest> people;

    public People() {
        this.people = new ArrayList<>();
    }

    public void add(Guest guest){
        this.people.add(guest);
    }

    public People filterByCity(String city){
        People peopleFromCity = new People();

        for (Guest person : people)
            if (person.isFromCity(city))
                peopleFromCity.add(person);

        return peopleFromCity;
    }

    public People filterByCountry(String country){
        People peopleFromCountry = new People();

        for (Guest person : people)
            if (person.isFromCountry(country))
                peopleFromCountry.add(person);

        return peopleFromCountry;
    }

    public People aboveAge(int age){
        People peopleAboveAge = new People();

        for (Guest person : people)
            if (person.isOlderThan(age)) {
                peopleAboveAge.add(person);
            }

        return peopleAboveAge;
    }

    public People aboveAge(String age){
        int thresholdsAge = Integer.parseInt(age);
        return aboveAge(thresholdsAge);
    }

    public Iterator<Guest> iterator() {
        return people.iterator();
    }
}
