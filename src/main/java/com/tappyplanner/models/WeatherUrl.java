package com.tappyplanner.models;

public class WeatherUrl {

    public String url;
    public String apiKey;

    public WeatherUrl(){
        super();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
