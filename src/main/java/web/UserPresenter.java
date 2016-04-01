package web;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import data.daos.UserDao;
import data.entities.User;


@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
@SessionAttributes("name")
public class UserPresenter {

    @Autowired
    private ServletContext servletContext;
    
    @Autowired
    private UserDao userDao;


    public UserPresenter() {
    }

    // Se ejecuta siempre y antes. Añade un atributo al Model
    @ModelAttribute("now")
    public String now() {
        return new SimpleDateFormat("EEEE, d MMM yyyy HH:mm:ss").format(new Date());
    }

    @RequestMapping("/user-list")
    public ModelAndView listUsers(Model model) {
    	ModelAndView modelAndView = new ModelAndView("/jsp/userList");
        modelAndView.addObject("userList", userDao.findAll());
        return modelAndView;
    }
    
    @RequestMapping(value = {"/delete-user/{id}"})
    public String deleteUser(@PathVariable int id, Model model) {
        userDao.delete(userDao.findOne(id));
        model.addAttribute("userList", userDao.findAll());
        return "/jsp/userList";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String createUser(Model model) {
    	Calendar calendar = Calendar.getInstance();
  	    calendar.add(Calendar.YEAR, -20);
        User newUser = new User("newUser", "mail@mail.com", "password", calendar);
    	model.addAttribute("user", newUser);
        return "/jsp/createUser";
    }  
    

}
