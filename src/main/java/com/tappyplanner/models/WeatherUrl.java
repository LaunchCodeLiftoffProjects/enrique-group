package com.tappyplanner.models;

public class WeatherUrl {

    private String url;
    private String apiKey = "01c043160eb542c29c4629d3679ac8ec";

    public WeatherUrl() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}