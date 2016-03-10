package bigBirthday.guest.specifics;

public class Gender {
    private final String gender;

    private Gender(String gender) {
        this.gender = gender;
    }

    public static Gender defineGenderAs(String gender) throws Exception, Error {
        String genderInUpperCase = gender.toUpperCase();
        if(genderInUpperCase.equals("FEMALE") || genderInUpperCase.equals("MALE") )
            return new Gender(genderInUpperCase);
        throw new Error("Error in data given....\nInstead of gender something else is given....");
    }

    public String getInitial(){
        return gender.equals("MALE") ? "Mr" : "Mrs";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gender)) return false;

        Gender gender1 = (Gender) o;

        return gender.equals(gender1.gender);
    }

    @Override
    public int hashCode() {
        return gender.hashCode();
    }
}
