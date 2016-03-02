package business.api;

import java.util.Calendar;

import data.entities.User;
import business.controllers.UserController;

public class UserControllerMock extends UserController {

    private User user = new User("", "", "", Calendar.getInstance());

    @Override
    public boolean registration(User user) {
        boolean result = !this.user.getUsername().equals(user.getUsername()) && !this.user.getEmail().equals(user.getEmail());
        this.user = user;
        return result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
