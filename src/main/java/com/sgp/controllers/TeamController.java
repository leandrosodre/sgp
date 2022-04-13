package com.sgp.controllers;

import com.sgp.models.Team;
import com.sgp.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;

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

    @GetMapping("/team/{teamId}")
    public ModelAndView editTeam(@PathVariable final long teamId) {
        final ModelAndView mv = new ModelAndView("teams/updateTeam");
        final Team team = teamRepository.findByTeamId(teamId).orElseThrow(EntityNotFoundException::new);
        mv.addObject("team", team);

        return mv;
    }

    @PostMapping("/team/{teamId}")
    public String updateTeam(final Team team) {
        teamRepository.save(team);
        return "redirect:/teams";
    }
}
