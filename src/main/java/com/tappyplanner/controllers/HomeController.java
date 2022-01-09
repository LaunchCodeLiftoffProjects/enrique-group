package com.tappyplanner.controllers;

import com.tappyplanner.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private static List<Task> items = new ArrayList<>();



    @GetMapping()
    String displayhome(Model model){
       model.addAttribute("items", items );
       return "user/home";
    }

    @GetMapping("/home")
    String renderhome(Model model){
        model.addAttribute("items", items );
        return "user/home";
    }

    @GetMapping("/create")
    String displayform(Model model){
        return "user/create";
    }

    @PostMapping("create")
    public String createTask(@RequestParam String itemName){
        items.add(new Task(itemName));
        return "user/home";
    }
}
