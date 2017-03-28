package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by Kevin on 3/23/2017.
 */

@Controller
@RequestMapping("user")
public class UserController {

//    @RequestMapping(value="add", method = RequestMethod.GET)
//    public String displayAdd(Model model) {
//        model.addAttribute("title", "Add a User");
//        return "user/add";
//    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAdd(Model model) {
        model.addAttribute("title", "Add a User");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, @RequestParam String verify) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add a User");
            model.addAttribute(user); //It was working without this in here...
            return "user/add";
        } else if ((null == verify)) {
            model.addAttribute("title", "Add a User"); //This seems to not be required, since it is never caught...
            model.addAttribute("message", "Please enter a password AND verify it!");
            return "user/add";
        } else if (!user.getPassword().equals(verify)) {
            model.addAttribute("title", "Add a User");
            model.addAttribute("message", "Passwords did not match!!");
            return "user/add";
        } else {
            model.addAttribute("title", "User Homepage");
            model.addAttribute("newUsername", user.getUsername());
            return "user/index";
            // TODO How do I return localhost:8080/user/index here?
        }
    }

//        if (user.getPassword().equals(verify)) {
//            model.addAttribute("title", "User Homepage");
//            model.addAttribute("newUser", user.getUsername());
//            model.addAttribute(user);
//            //return "redirect:/cheese/user/index";
//            return "user/index";
//        } else {
//            model.addAttribute("username", user.getUsername());
//            model.addAttribute("email", user.getEmail());
//            model.addAttribute("title", "Add a User");
//            model.addAttribute("message", "Passwords did not match!");
//            return "user/add";




}
