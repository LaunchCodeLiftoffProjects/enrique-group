package com.tappyplanner.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* Giovanni Brex created
 * on 1/8/2022 inside
 * the package -
 * com.tappyplanner.models */
public class WeatherMapAPI {
//    Method #1
//
//    private final Object weatherData;
//
//    BufferedReader reader;
//     String line;
//     StringBuffer responseContent = new StringBuffer();
//     URL url;
//
//
//    {
//        HttpURLConnection connection = null;
//        try {
//            url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=63033&appid=01c043160eb542c29c4629d3679ac8ec&units=imperial");
//            connection = (HttpURLConnection) url.openConnection();
//
//            // Request setup
//            connection.setRequestMethod("GET");
//            connection.setConnectTimeout(5000);
//            connection.setReadTimeout(5000);
//
//            Integer status = connection.getResponseCode();
//
//
//            if (status > 299) {
//                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
//            } else {
//                reader = new BufferedReader((new InputStreamReader(connection.getInputStream())));
//            }
//            while ((line = reader.readLine()) != null) {
//                responseContent.append(line);
//            }
//            reader.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            assert connection != null;
//            connection.disconnect();
//        }
//    }
//
//
//    public WeatherMapAPI() {
//        this.weatherData = parse(responseContent.toString());
//    }
//
//
//    private Object parse(String responseBody) {
//        JSONObject obj = new JSONObject(responseBody);
//        Object weather = (Object)obj;
//
//
//        return weather;
//    }
//
//    public Object getWeatherData() {
//
//
//        ResponseEntity<String> resp= responseContent;
//
//        ObjectMapper mapper = new ObjectMapper();
//        Weather weatherData = mapper.readValue(responseContent.getBody(), Weather.class);
//        model.addAttribute("weatherData", weatherData);
//
//
//        return weatherData;
//    }
//
}

