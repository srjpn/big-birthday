package bigBirthday.guest.filters;

import bigBirthday.People;
import bigBirthday.guest.Guest;

import java.util.HashSet;

public class Filter {
    private final HashSet<FilterCriteria> filterCriteria;

    public Filter() {
        this.filterCriteria = new HashSet<>();
    }

    public void addCriteria(FilterCriteria criteria){
        filterCriteria.add(criteria);
    }

    public People filter(People people){
        People filteredPeople = new People();

        for (Guest person : people){
            boolean filterable = true;
            for (FilterCriteria filterCriteria : this.filterCriteria)
                filterable = filterable && filterCriteria.isToBeFiltered(person);
            if(filterable)
                filteredPeople.add(person);
        }

        return filteredPeople;
    }

}
