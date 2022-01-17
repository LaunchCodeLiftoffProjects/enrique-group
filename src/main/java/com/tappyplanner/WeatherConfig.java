package com.tappyplanner;

import com.tappyplanner.models.WeatherUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan
public class WeatherConfig {

    private String url;

    private String apikey;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){

        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }

    @Bean
    public WeatherUrl weatherUrl(){
        WeatherUrl weatherUrl = new WeatherUrl();
        weatherUrl.setUrl(url);
        weatherUrl.setApiKey(apikey);
        return weatherUrl;
    }

}
