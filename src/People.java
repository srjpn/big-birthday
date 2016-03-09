import guest.Guest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class People implements Iterable<Guest>{
    private final Set<Guest> people;
    private HashSet<Filter> filters;

    public People() {
        this.people = new HashSet<>();
        this.filters = new HashSet<>();
    }

    public void add(Guest guest){
        this.people.add(guest);
    }

    public People filterByCity(String city){
        People peopleFromCity = new People();

        for (Guest person : people)
            if (person.isFromCity(city)) peopleFromCity.add(person);

        return peopleFromCity;
    }

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    public People filter(){
        People peopleFromCountry = new People();

        for (Guest person : people){
            int status = 0;
            for (Filter filter : filters)
                if (filter.filter(person)) status++;
            if(status==filters.size())
                peopleFromCountry.add(person);
        }

        return peopleFromCountry;
    }

    public People filterByCountry(String country){
        People peopleFromCountry = new People();

        for (Guest person : people)
            if (person.isFromCountry(country)) peopleFromCountry.add(person);

        return peopleFromCountry;
    }

    public People aboveAge(int age){
        People peopleAboveAge = new People();

        for (Guest person : people)
            if (person.isOlderThan(age)) peopleAboveAge.add(person);

        return peopleAboveAge;
    }

    public People aboveAge(String age){
        int thresholdsAge = Integer.parseInt(age);
        return aboveAge(thresholdsAge);
    }

    @Override
    public Iterator<Guest> iterator() {
        return people.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people1 = (People) o;

        return people.equals(people1.people);
    }

    @Override
    public int hashCode() {
        return people.hashCode();
    }
}
