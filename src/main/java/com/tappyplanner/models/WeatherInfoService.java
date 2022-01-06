package com.tappyplanner.models;


import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Preconditions;
import org.springframework.boot.json.GsonJsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherInfoService {



    public Weather GetWeatherInfo() throws IOException {

    URL url = new URL("http://api.openweathermap.org/data/2.5/forecast?id=524901&appid={01c043160eb542c29c4629d3679ac8ec}");
    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
    connection.setRequestMethod("GET");
    connection.setRequestProperty("Accept","application/json");

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
    Weather weather = gson.fromJson(weatherInfoJSon, Weather.class);

    return weather;

}

}
