package guest.specifics;

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
        if(gender.equals("MALE"))
            return "Mr";
        return "Mrs";
    }
}
