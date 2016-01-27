package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.entities.Token;
import business.entities.User;
import data.daos.TokenDao;
import data.daos.UserDao;

@Controller
public class TokenController {

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private UserDao userDao;

    public String create(String username) {
        User user = userDao.findDistinctByUsernameOrEmail(username, username);
        assert user != null;
        Token token = new Token(user);
        tokenDao.save(token);
        return token.getValue();
    }
}
