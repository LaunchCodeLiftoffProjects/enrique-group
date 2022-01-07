package com.tappyplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* Giovanni Brex created
 * on 12/21/2021 inside
 * the package -
 * com.tappyplanner.controllers */


@Controller
public class HomeController {

    @RequestMapping("index")
    public String index(Model model) {
        model.addAttribute("title", "My Tabby List");
        model.addAttribute("register");

        return "index";
    }

}
