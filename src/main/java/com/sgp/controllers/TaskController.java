package com.sgp.controllers;

import com.sgp.models.Task;
import com.sgp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping("/tasks")
    public ModelAndView tasks() {
        final ModelAndView mv = new ModelAndView("tasks/taskList");
        final Iterable<Task> tasks = taskRepository.findAll();
        mv.addObject("tasks", tasks);
        return mv;
    }

    @GetMapping(value = "/createTask")
    public String form(final Model model) {

        return "tasks/createTask";
    }
}
