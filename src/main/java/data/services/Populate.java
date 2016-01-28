package data.services;

import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.entities.Authorization;
import business.entities.User;
import business.utils.Role;
import data.daos.AuthorizationDao;
import data.daos.UserDao;

@Service
@Transactional
public class Populate {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthorizationDao authorizationDao;

    @PostConstruct
    public void createDefaultAdmin() {
        User admin = new User("admin", "admin@gmail.com", "admin", new GregorianCalendar(1979, 07, 22));
        User adminSaved = userDao.findDistinctByUsernameOrEmail(admin.getUsername(), admin.getEmail());
        if (adminSaved == null) {
            userDao.save(admin);
            authorizationDao.save(new Authorization(admin, Role.ADMIN));
        }
    }
}
