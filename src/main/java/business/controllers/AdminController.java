package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import data.services.PaddleService;

@Controller
public class AdminController {
    
    private PaddleService paddleService;
    
    @Autowired
    public void setPaddleService(PaddleService paddleService) {
        this.paddleService = paddleService;
    }

    public void deleteAllExceptAdmin() {
        paddleService.deleteAllExceptAdmin();
    }

}
