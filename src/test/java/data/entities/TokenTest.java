package data.entities;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

public class TokenTest {

    @Test
    public void testTokenUser() {
        User user = new User("u", "u@gmail.com", "p", Calendar.getInstance());
        Token token = new Token(user);
        assertTrue(token.getValue().length() > 20);
    }
    
    @Test
    public void testhasExpired() {
    	Calendar dateToTest = Calendar.getInstance();
    	User user = new User("u", "u@gmail.com", "p", dateToTest);
    	Token token = new Token(user);
    	assertTrue(!token.hasExpired());
    	Token tokenExpired = new Token(user);
    	dateToTest.add(Calendar.MINUTE, -60);
    	tokenExpired.setCreationDate(dateToTest);
    	assertTrue(tokenExpired.hasExpired());
    }

}
