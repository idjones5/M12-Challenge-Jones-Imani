package com.company;

import java.util.List;

public class State {
    private String name;
    private List<City> cityList;

    // constructor
    public State(String name) {
        this.name = name;
        this.cityList = cityList;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
