package com.sgp.controllers;

import com.sgp.models.Sprint;
import com.sgp.models.Team;
import com.sgp.repositories.SprintRepository;
import com.sgp.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SprintController {

    final SprintRepository sprintRepository;
    final TeamRepository teamRepository;

    @Autowired
    public SprintController(final SprintRepository sprintRepository, final TeamRepository teamRepository) {
        this.sprintRepository = sprintRepository;
        this.teamRepository = teamRepository;
    }

    @RequestMapping("/sprints")
    public ModelAndView tasks() {
        final ModelAndView mv = new ModelAndView("sprints/sprintList");
        final Iterable<Sprint> sprints = sprintRepository.findAll();
        mv.addObject("sprints", sprints);
        return mv;
    }

    @GetMapping(value = "/createSprint")
    public ModelAndView form() {
        final ModelAndView mv = new ModelAndView("sprints/createSprint");
        final Iterable<Team> teams = teamRepository.findAll();
        mv.addObject("teams", teams);
        return mv;
    }

    @PostMapping(value = "/createSprint")
    public String createSprint(final Sprint sprint) {
        sprint.setOpen(true);
        sprintRepository.save(sprint);
        return "redirect:/sprints";
    }

    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
