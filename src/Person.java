/**
 * Created by soorajp on 01/03/16.
 */
public class Person {
    private final Name name;
    private final Gender gender;
    private final int age;
    private final Address address;

    private Person(Name name, Gender gender, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public static void createPerson(String fromCSV){

    }
}
