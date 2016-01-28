package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.daos.AuthorizationDao;
import data.daos.UserDao;
import business.entities.Authorization;
import business.entities.User;
import business.utils.Role;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private AuthorizationDao authorizationDao;

    public boolean create(User user) {
        try {
            userDao.save(user);
            authorizationDao.save(new Authorization(user, Role.PLAYER));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
