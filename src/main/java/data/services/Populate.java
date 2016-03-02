package data.services;

import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.daos.AuthorizationDao;
import data.daos.UserDao;
import data.entities.Authorization;
import data.entities.Role;
import data.entities.User;

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
        User adminSaved = userDao.findByUsernameOrEmail(admin.getUsername());
        if (adminSaved == null) {
            userDao.save(admin);
            authorizationDao.save(new Authorization(admin, Role.ADMIN));
        }
    }
    
    
}
