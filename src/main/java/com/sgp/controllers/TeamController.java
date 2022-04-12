package com.sgp.controllers;

import com.sgp.models.Team;
import com.sgp.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @RequestMapping("/teams")
    public ModelAndView tasks() {
        final ModelAndView mv = new ModelAndView("teams/teamList");
        final Iterable<Team> teams = teamRepository.findAll();
        mv.addObject("teams", teams);
        return mv;
    }

    @GetMapping(value = "/createTeam")
    public String form() {
        return "teams/createTeam";
    }

    @PostMapping(value = "/createTeam")
    public String createTeam(final Team team) {
        teamRepository.save(team);
        return "redirect:/teams";
    }
}
