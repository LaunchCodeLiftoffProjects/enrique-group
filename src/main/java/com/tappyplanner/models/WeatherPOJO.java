package com.tappyplanner.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/* Giovanni Brex created
 * on 1/15/2022 inside
 * the package -
 * com.tappyplanner.models */

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherPOJO {

    private Object cod;

    private List<Object> list;

    private String description;

    private Double temp;

    public WeatherPOJO() {

    }

    public WeatherPOJO(Object cod, List<Object> list, String description) {
        this.cod = cod;
        this.list = list;
        this.description = description;
    }

    public Object getCod() {
        return cod;
    }

    public void setCod(Object cod) {
        this.cod = cod;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }
}
