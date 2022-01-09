package com.tappyplanner.controllers;

import com.tappyplanner.models.Task;
import com.tappyplanner.models.data.TaskData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {





    @GetMapping()
    String displayhome(Model model){
       model.addAttribute("items", TaskData.getAll());
       return "user/home";
    }

    @GetMapping("/home")
    String renderhome(Model model){
        model.addAttribute("items", TaskData.getAll());
        return "user/home";
    }

    @GetMapping("/create")
    String displayform(Model model){
        return "user/create";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task newTask){
        TaskData.add(newTask);
        return "user/home";
    }

    @GetMapping("/delete")
    public String displayDeleteForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("tasks", TaskData.getAll());
        return "user/delete";
    }

    @PostMapping("/delete")
    public String deleteProcess(@RequestParam(required = false) int[] taskIds) {
        if(taskIds != null) {
            for (int id : taskIds) {
                TaskData.remove(id);
            }
        }
        return"user/home";
    }
}
