package com.tappyplanner.models;


import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;


public class WeatherInfoService {



    public WeatherModel GetWeatherInfo() throws IOException {

    URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=63033&appid=01c043160eb542c29c4629d3679ac8ec&units=imperial");
    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Accept","application/json");

    int status = connection.getResponseCode();
    System.out.println(status);


    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();


    while((inputLine = reader.readLine()) != null){
        content.append(inputLine);
    }

    reader.close();
    connection.disconnect();

    String weatherInfoJSon = content.toString();
    System.out.println(weatherInfoJSon);

    Gson gson = new Gson();
    WeatherModel weather = gson.fromJson(weatherInfoJSon, WeatherModel.class);

    System.out.println(weather);

    return weather;

}

}
