import guest.Guest;
import guest.specifics.Address;
import guest.specifics.Gender;
import guest.specifics.Name;

import java.util.ArrayList;

public class PersonCreator {
    private final String data;

    public PersonCreator(String data) {
        this.data = data;
    }

    public ArrayList<Guest> createPersonFromCSV() throws Exception {
        String[] csvData = data.split("\n");
        ArrayList<Guest> guests = new ArrayList<>(10);

        for (String personData : csvData) {
            String[] personDetails = personData.split(",");
            Name name = new Name(personDetails[0],personDetails[1]);
            Gender gender = Gender.defineGenderAs(personDetails[2]);
            Integer age = Integer.parseUnsignedInt(personDetails[3]);
            Address address = new Address(personDetails[4],personDetails[5],personDetails[6]);
            Guest guest = new Guest(name, gender, age, address);
            guests.add(guest);
        }
        return guests;
    }
}
