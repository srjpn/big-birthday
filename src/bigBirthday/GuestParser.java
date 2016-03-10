package bigBirthday;

import bigBirthday.specifics.Address;
import bigBirthday.specifics.Age;
import bigBirthday.specifics.Gender;
import bigBirthday.specifics.Name;

public class GuestParser {

    public static People createPersonFromCSV(String data) throws Exception, Error {
        String[] csvData = data.split("\n");
        People guests = new People();

        for (String personData : csvData) {
            Guest guest = createGuest(personData);
            guests.add(guest);
        }
        return guests;
    }

    private static Guest createGuest(String personData) throws Exception, Error {
        String[] personDetails = personData.split(",");
        Name name = new Name(personDetails[0],personDetails[1]);
        Gender gender = Gender.defineGenderAs(personDetails[2]);
        Age age = new Age(Integer.parseUnsignedInt(personDetails[3]));
        Address address = new Address(personDetails[4],personDetails[5],personDetails[6]);
        return new Guest(name, gender, age, address);
    }
}
