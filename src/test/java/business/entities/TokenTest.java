package business.entities;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import java.util.Calendar;

import org.junit.Test;

public class TokenTest {

    @Test
    public void testTokenUser() {
        User user = new User("u", "u@gmail.com", "p", Calendar.getInstance());
        Token token = new Token(user);
        assertTrue(token.getValue().length() > 20);
        assertNotEquals(token, new Token(user));
    }

}
