package com.sgp.controllers;

import com.sgp.models.Team;
import com.sgp.models.User;
import com.sgp.repositories.TeamRepository;
import com.sgp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TeamRepository teamRepository;

    @RequestMapping("/users")
    public ModelAndView tasks() {
        final ModelAndView mv = new ModelAndView("users/userList");
        final Iterable<User> users = userRepository.findAll();
        mv.addObject("users", users);
        return mv;
    }

    @GetMapping(value = "/createUser")
    public ModelAndView form() {
        final ModelAndView mv = new ModelAndView("users/createUser");
        Iterable<Team> teams = teamRepository.findAll();
        mv.addObject("teams", teams);
        return mv;
    }

    @PostMapping(value = "/createUser")
    public String createUser(final Model model) {

        return "users/createUser";
    }
}
