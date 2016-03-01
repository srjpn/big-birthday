public class Person {
    private final Name name;
    private final Gender gender;
    private final int age;
    private final Address address;

    public Person(Name name, Gender gender, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public MailingAddress getMailAddress(){
        return new MailingAddress(this.name, this.gender, this.address);
    }
}

