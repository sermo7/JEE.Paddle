package data.daos;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.services.GenericService;
import business.entities.Token;
import business.entities.User;

@Service
public class DaosService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private GenericService genericService;

    public User[] createUsers(int size) {
        User[] users = new User[size];
        for (int i = 0; i < size; i++) {
            users[i] = new User("u" + i, "u" + i + "@gmail.com", "p" + i, Calendar.getInstance());
            userDao.save(users[i]);
        }
        return users;
    }

    public User createUser() {
        User user = new User("uX", "uX@gmail.com", "pX", Calendar.getInstance());
        userDao.save(user);
        return user;
    }

    public Token[] createTokensAndUsers(int size) {
        User[] users = this.createUsers(size);
        Token[] tokens = new Token[size];
        for (int i = 0; i < size; i++) {
            tokens[i] = new Token(users[i]);
            tokenDao.save(tokens[i]);
        }
        return tokens;
    }

    public void deleteAll() {
        genericService.deleteAllExceptAdmin();
    }
}
