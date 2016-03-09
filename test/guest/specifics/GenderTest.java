package guest.specifics;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenderTest {

    @Test
    public void defineGenderAs_gives_gender_object() throws Exception {
        Object gender = Gender.defineGenderAs("male");
        assertTrue(gender != null);
    }

    @Test
    public void defineGenderAs_throws_exception_if_given_unvalid_gender() throws Exception {
        try{
            Gender.defineGenderAs("kozhi");
        }
        catch (Error e){
            assertEquals("Error in data given....\n" +
                    "Instead of gender something else is given....",e.getMessage());
        }
    }

    @Test
    public void testGetInitial_gives_inital_Mr_for_male_gender() throws Exception {
        Gender gender = Gender.defineGenderAs("male");
        assertEquals("Mr",gender.getInitial());
    }

    @Test
    public void testGetInitial_gives_inital_Mrs_for_female_gender() throws Exception {
        Gender gender = Gender.defineGenderAs("female");
        assertEquals("Mrs",gender.getInitial());
    }

}