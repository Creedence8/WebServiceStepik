package l2.accounts;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Cole S' Offe on 31.03.2017.
 */
public class UserProfileTest {
    @Ignore
    @Test
    public void getPass() throws Exception {
        fail();
    }

    @Test
    public void getEmail() throws Exception {
        assertTrue(true);
    }

    @Test
    public void getLogin() throws Exception {
        UserProfile up = new UserProfile("kek");
        assertEquals("keki", up.getLogin());
    }




}