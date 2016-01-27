package business.api;

import business.controllers.UserController;
import business.entities.User;

public class UserControllerMock extends UserController {

    @Override
    public boolean create(User user) {
        return !user.getUsername().equals("u") && !user.getUsername().equals("e");
    }

}
