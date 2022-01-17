package com.tappyplanner.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tappyplanner.models.FormCityAttribute;
import com.tappyplanner.models.Weather;
import com.tappyplanner.models.WeatherUrl;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

public class WeatherController {


    RestTemplate restTemplate;

    private WeatherUrl WeatherData;

    public String CityForm(Model model){
        model.addAttribute("city", new FormCityAttribute());
        return "formData"
    }

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
    }
}
