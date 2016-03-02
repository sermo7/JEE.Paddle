package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.daos.AuthorizationDao;
import data.daos.UserDao;
import business.entities.Authorization;
import business.entities.Role;
import business.entities.User;

@Controller
public class UserController {

    private UserDao userDao;

    private AuthorizationDao authorizationDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setAuthorizationDao(AuthorizationDao authorizationDao) {
        this.authorizationDao = authorizationDao;
    }

    public boolean registration(User user) {
        try {
            userDao.save(user);
            authorizationDao.save(new Authorization(user, Role.PLAYER));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
