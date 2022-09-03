package com.pp.springmvc.controllers;

import com.pp.springmvc.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersServices usersServices;


    @Autowired
    public UsersController(UsersServices usersServices) {
        this.usersServices = usersServices;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        return null;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", usersServices.getUserById(id));
        return "users";

    }
}

