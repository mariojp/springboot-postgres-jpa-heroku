package com.isdzulqor.coba.heroku.controller;

import com.isdzulqor.coba.heroku.entity.User;
import com.isdzulqor.coba.heroku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by isdzulqor on 3/27/17.
 */
@Controller
public class DummyController {

    @Autowired
    UserService userService;

    @RequestMapping("/iskandar")
    @ResponseBody
    public String coba(){
        return "iskandar";
    }

    @RequestMapping("/buat-user")
    @ResponseBody
    public String tesCreateUser(@RequestParam(value="first", required=true) String first,
                                @RequestParam(value="last", required=true) String last) throws Exception {
        User userToBeSaved = new User();
        userToBeSaved.setFirst(first);
        userToBeSaved.setLast(last);
        userToBeSaved.setCity("city");
        userToBeSaved.setCompany("company");
        userToBeSaved.setEmail("email");
        userService.create(userToBeSaved);
        return "iskandar";
    }


    @RequestMapping("/")
    public String home(Model model) {
        return "home";
    }

    @RequestMapping("/createuserform")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createuser";
    }

    @RequestMapping("/users")
    public String users(Model model) {
        try {
            List users = new ArrayList<>();
            users = userService.findAll();

            model.addAttribute("users", users);
            return "user";
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(value="/createuser", method= RequestMethod.POST)
    public String createUser(@ModelAttribute User user, Model model) throws Exception {
        model.addAttribute("user", user);
        userService.create(user);
        return "result";
    }

}
