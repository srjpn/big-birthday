package guest.specifics;

public class Name {
    private final String firstName;
    private final String secondName;

    public Name(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String firstNameFirst(){
        return this.firstName+" "+this.secondName;
    }

    public String secondNameFirst(){
        return this.secondName+" "+this.firstName;
    }

    @Override
    public String toString(){
        return this.firstNameFirst();
    }

}
