package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.daos.UserDao;
import business.entities.User;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    public boolean create(User user) {
        try {
            userDao.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
