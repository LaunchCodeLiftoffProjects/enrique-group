package com.tappyplanner.controllers;

import com.tappyplanner.models.WeatherModel;
import com.tappyplanner.models.WeatherInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


public class WeatherController {

    @GetMapping("/weather")
    public String Index(Model model) throws IOException {

        WeatherInfoService weatherInfoService = new WeatherInfoService();
        WeatherModel weather = weatherInfoService.GetWeatherInfo();

        model.addAttribute("weather", weather);

        return "weather";
    }

}
