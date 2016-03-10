package bigBirthday.guest;

import bigBirthday.People;
import bigBirthday.guest.specifics.Address;
import bigBirthday.guest.specifics.Age;
import bigBirthday.guest.specifics.Gender;
import bigBirthday.guest.specifics.Name;

public class GuestParser {
    private String data;

    public GuestParser(String data) {
        this.data = data;
    }

    public People createPersonFromCSV() throws Exception, Error {
        String[] csvData = data.split("\n");
        People guests = new People();

        for (String personData : csvData) {
            Guest guest = createGuest(personData);
            guests.add(guest);
        }
        return guests;
    }

    private Guest createGuest(String personData) throws Exception, Error {
        String[] personDetails = personData.split(",");
        Name name = new Name(personDetails[0],personDetails[1]);
        Gender gender = Gender.defineGenderAs(personDetails[2]);
        Age age = new Age(Integer.parseUnsignedInt(personDetails[3]));
        Address address = new Address(personDetails[4],personDetails[5],personDetails[6]);
        return new Guest(name, gender, age, address);
    }
}
