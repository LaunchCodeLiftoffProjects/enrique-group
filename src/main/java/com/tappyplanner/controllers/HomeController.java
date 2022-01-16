package com.tappyplanner.controllers;

import com.tappyplanner.models.WeatherJsonParser;
import com.tappyplanner.models.WeatherMapAPI;
import com.tappyplanner.models.WeatherPOJO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private final WeatherMapAPI currentWeather = new WeatherMapAPI();

    private static List<String> items = new ArrayList<>();



    @GetMapping()
    String displayhome(Model model) throws IOException {
       model.addAttribute("items", items );
       model.addAttribute("weather",
               WeatherJsonParser.fromJson(WeatherJsonParser.parse(currentWeather.getWeatherData()), WeatherPOJO.class));
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
        items.add(itemName);
        return "user/home";
    }
}
