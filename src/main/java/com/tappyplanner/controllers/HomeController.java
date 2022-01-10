package com.tappyplanner.controllers;

import com.tappyplanner.models.WeatherInfoService;
import com.tappyplanner.models.WeatherModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/* Giovanni Brex created
 * on 12/21/2021 inside
 * the package -
 * com.tappyplanner.controllers */


@Controller
public class HomeController {
    @GetMapping("/")
    public String Index(Model model) throws IOException {

        WeatherInfoService weatherInfoService = new WeatherInfoService();
        WeatherModel weather = weatherInfoService.GetWeatherInfo();

        model.addAttribute("weather", weather);

        return "index";
    }


}
