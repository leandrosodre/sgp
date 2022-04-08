package com.sgp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {

    @RequestMapping("/")
    public String login() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String logout(final Model model) {
        model.addAttribute("logout", true);
        return "login";
    }

    @PostMapping(value = "/login")
    public String erroLogin(final Model model) {
        model.addAttribute("erroLogin", true);
        return "login";
    }
}
