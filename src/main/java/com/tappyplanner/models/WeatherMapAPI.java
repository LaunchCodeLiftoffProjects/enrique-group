package com.tappyplanner.models;

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

    private final String weatherData;

    BufferedReader reader;
     String line;
     StringBuffer responseContent = new StringBuffer();
     URL url;


    {
        HttpURLConnection connection = null;
        try {
            url = new URL("http://api.openweathermap.org/data/2.5/forecast?zip=63033&appid=01c043160eb542c29c4629d3679ac8ec&units=imperial");
            connection = (HttpURLConnection) url.openConnection();

            // Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            Integer status = connection.getResponseCode();


            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } else {
                reader = new BufferedReader((new InputStreamReader(connection.getInputStream())));
            }
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert connection != null;
            connection.disconnect();
        }
    }

    public WeatherMapAPI() {
        this.weatherData = responseContent.toString();
    }


    public String getWeatherData() {
        return weatherData;
    }

}
