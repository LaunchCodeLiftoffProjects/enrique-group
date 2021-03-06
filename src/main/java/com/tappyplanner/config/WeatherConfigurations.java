package com.tappyplanner.config;


import com.tappyplanner.models.WeatherUrl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan
public class WeatherConfigurations {

    @Value("${weather.url}")
    private String url;

    @Value("${weather.apikey}")
    private String apikey;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }

    @Bean
    public WeatherUrl weatherUrl() {

        WeatherUrl weatherUrl = new WeatherUrl();
        weatherUrl.setUrl("api.openweathermap.org/data/2.5/weather");
        weatherUrl.setApiKey("01c043160eb542c29c4629d3679ac8ec");
        return weatherUrl;
    }

}