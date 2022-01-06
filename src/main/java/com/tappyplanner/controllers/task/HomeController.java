package com.tappyplanner.controllers.task;

import com.MVC.Thymeleaf.model.item;
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

    private static List<String> items = new ArrayList<>();



    @GetMapping()
    String displayhome(Model model){
       model.addAttribute("items", items );
       return "index";
    }

    @GetMapping("/index")
    String renderhome(Model model){
        model.addAttribute("items", items );
        return "index";
    }

    @GetMapping("/create")
    String displayform(Model model){
        return "create";
    }

    @PostMapping("create")
    public String createTask(@RequestParam String itemName){
        items.add(itemName);
        return "redirect:";
    }
}
