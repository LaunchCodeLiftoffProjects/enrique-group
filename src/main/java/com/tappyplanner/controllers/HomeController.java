package com.tappyplanner.controllers;

import com.tappyplanner.models.Task;
import com.tappyplanner.models.data.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private TaskRepository taskRepository;


    @PostMapping("/home")
    String displayhome(Model model){
       model.addAttribute("items", taskRepository.findAll());
       return "user/home";
    }


    @GetMapping("/home")
    String renderhome(Model model){
        model.addAttribute("items", taskRepository.findAll());
        return "user/home";
    }

    @GetMapping("/create")
    String displayform(Model model){
        return "user/create";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task newTask){
        taskRepository.save(newTask);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String displayDeleteForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("tasks", taskRepository.findAll());
        return "user/delete";
    }

    @PostMapping("/delete")
    public String deleteProcess(@RequestParam(required = false) int[] taskIds) {
        if(taskIds != null) {
            for (int id : taskIds) {
                taskRepository.deleteById(id);
            }
        }
        return "redirect:/home";
    }
}
