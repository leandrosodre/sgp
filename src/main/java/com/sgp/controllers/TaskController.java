package com.sgp.controllers;

import com.sgp.models.Sprint;
import com.sgp.models.Task;
import com.sgp.models.Team;
import com.sgp.models.User;
import com.sgp.repositories.SprintRepository;
import com.sgp.repositories.TaskRepository;
import com.sgp.repositories.TeamRepository;
import com.sgp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;

@Controller
public class TaskController {

    final TaskRepository taskRepository;
    final TeamRepository teamRepository;
    final UserRepository userRepository;
    final SprintRepository sprintRepository;

    @Autowired
    public TaskController(final TaskRepository taskRepository, final TeamRepository teamRepository, final UserRepository userRepository, final SprintRepository sprintRepository) {
        this.taskRepository = taskRepository;
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.sprintRepository = sprintRepository;
    }

    @RequestMapping("/tasks")
    public ModelAndView tasks() {
        final ModelAndView mv = new ModelAndView("tasks/taskList");
        final Iterable<Task> tasks = taskRepository.findAll();
        mv.addObject("tasks", tasks);

        return mv;
    }

    @GetMapping(value = "/createTask")
    public ModelAndView form() {
        final ModelAndView mv = new ModelAndView("tasks/createTask");
        final Iterable<User> users = userRepository.findAll();
        final Iterable<Team> teams = teamRepository.findAll();
        final Iterable<Sprint> sprints = sprintRepository.findAllOpenSprints();
        mv.addObject("users", users);
        mv.addObject("teams", teams);
        mv.addObject("sprints", sprints);
        return mv;
    }

    @GetMapping("/task/{taskId}")
    public ModelAndView editTask(@PathVariable final long taskId) {
        final ModelAndView mv = new ModelAndView("tasks/updateTask");

        final Task task = taskRepository.findByTaskId(taskId).orElseThrow(EntityNotFoundException::new);
        mv.addObject("task", task);

        final Iterable<Team> teams = teamRepository.findAll();
        final Iterable<Sprint> sprints = sprintRepository.findAll();
        final Iterable<User> users = userRepository.findAll();

        mv.addObject("teams", teams);
        mv.addObject("sprints", sprints);
        mv.addObject("users", users);

        return mv;
    }

    @PostMapping(value = "/createTask")
    public String createTask(final Task task) {
        taskRepository.save(task);
        return "redirect:/tasks";
    }


}
