import person.Person;
import person.specifics.Address;
import person.specifics.Gender;
import person.specifics.Name;

import java.util.ArrayList;

public class PersonCreator {
    private final String data;

    public PersonCreator(String data) {
        this.data = data;
    }

    public ArrayList<Person> createPersonFromCSV() throws Exception {
        String[] csvData = data.split("\n");
        ArrayList<Person> persons = new ArrayList<>(10);

        for (String personData : csvData) {
            String[] personDetails = personData.split(",");
            Name name = new Name(personDetails[0],personDetails[1]);
            Gender gender = Gender.defineGenderAs(personDetails[2]);
            Integer age = Integer.parseUnsignedInt(personDetails[3]);
            Address address = new Address(personDetails[4],personDetails[5],personDetails[6]);
            Person person = new Person(name, gender, age, address);
            persons.add(person);
        }
        return persons;
    }
}
