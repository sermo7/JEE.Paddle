package business.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.entities.Token;
import business.entities.User;
import data.daos.TokenDao;
import data.daos.UserDao;

@Controller
@Transactional
public class TokenController {

    private TokenDao tokenDao;

    private UserDao userDao;

    @Autowired
    public void setTokenDao(TokenDao tokenDao) {
        this.tokenDao = tokenDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String login(String username) {
        User user = userDao.findDistinctByUsernameOrEmail(username, username);
        assert user != null;
        Token token = tokenDao.findByUser(user);
        if (token != null) {
            tokenDao.delete(token);
        }
        token = new Token(user);
        tokenDao.save(token);
        return token.getValue();
    }
}
