package bigBirthday.guest.specifics;

import bigBirthday.specifics.Age;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AgeTest {

    @Test
    public void testIsOlderThan_returns_true_for_age_older_than_other() throws Exception {
        Age older = new Age(20);
        assertTrue(older.isAgeAbove(18));
    }

    @Test
    public void testIsOlderThan_returns_false_for_age_younger_than_other() throws Exception {
        Age older = new Age(18);
        assertTrue(!older.isAgeAbove(20));
    }

    @Test
    public void testEquals_returns_true_for_simlar_objects() throws Exception {

    }
}