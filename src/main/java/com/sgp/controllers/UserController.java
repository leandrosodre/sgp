package com.sgp.controllers;

import com.sgp.models.Role;
import com.sgp.models.Team;
import com.sgp.models.User;
import com.sgp.repositories.TeamRepository;
import com.sgp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    final UserRepository userRepository;
    final TeamRepository teamRepository;

    @Autowired
    public UserController(final UserRepository userRepository, final TeamRepository teamRepository) {
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
    }

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
        final Iterable<Team> teams = teamRepository.findAll();
        mv.addObject("teams", teams);
        return mv;
    }

    @PostMapping(value = "/createUser")
    public String createUser(final User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRoles(getUserRole(user.getType()));
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user/{userId}")
    public ModelAndView editUser(@PathVariable final long userId) {
        final ModelAndView mv = new ModelAndView("users/updateUser");
        final Iterable<Team> teams = teamRepository.findAll();
        final User user = userRepository.findByUserId(userId).orElseThrow(EntityNotFoundException::new);

        mv.addObject("user", user);
        mv.addObject("teams", teams);
        return mv;
    }

    @PostMapping("/user/{userId}")
    public String updateUser(final User user) {
        user.setRoles(getUserRole(user.getType()));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/users";
    }

    private List<Role> getUserRole(final int type) {

        return switch (type) {
            case 0 -> List.of(new Role("ROLE_ADMIN"));
            case 1 -> List.of(new Role("ROLE_PM"));
            case 2 -> List.of(new Role("ROLE_SM"));
            default -> List.of(new Role("ROLE_DEV"));
        };
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
