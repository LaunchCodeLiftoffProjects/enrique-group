package com.tappyplanner.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tappyplanner.models.FormCityAttribute;
import com.tappyplanner.models.Weather;
import com.tappyplanner.models.WeatherUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.stereotype.Controller;



import java.io.IOException;

@ComponentScan("com.spring.restapi.config")
@Controller
public class WeatherController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private WeatherUrl weatherData;

    @RequestMapping(value = "/weather", method= RequestMethod.GET)
    public String CityForm(Model model){
        model.addAttribute("city", new FormCityAttribute());
        return "formData";
    }

    @RequestMapping(value = "/weather",method=RequestMethod.POST )
    public String getWeather(Model model, @ModelAttribute FormCityAttribute city) throws JsonParseException, JsonMappingException, IOException{

        UriComponents uriComponents = UriComponentsBuilder
                    .newInstance()
                    .scheme("http")
                    .host(weatherData.getUrl())
                .path("")
                .query("q={keyword}&appid={appid}")
                .buildAndExpand(city.getCity(),weatherData.getApiKey());

        String uri = uriComponents.toUriString();

        ResponseEntity<String> resp = restTemplate.exchange(uri, HttpMethod.GET, null, String.class);

        ObjectMapper mapper = new ObjectMapper();
        Weather weather = mapper.readValue(resp.getBody(), Weather.class);

        return "weatherData";
    }
}
