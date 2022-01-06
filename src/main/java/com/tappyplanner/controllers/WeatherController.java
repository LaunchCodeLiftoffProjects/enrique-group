package com.tappyplanner.controllers;

import com.tappyplanner.models.Weather;
import com.tappyplanner.models.WeatherInfoService;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

public class WeatherController {

    @GetMapping("/")
    public String Index(Weather weather) throws IOException {

        WeatherInfoService weatherInfoService = new WeatherInfoService();
        Weather weather = weatherInfoService.GetWeatherInfo();

        weather.addAttribute("weather", weather);

        return "";
    }

}
