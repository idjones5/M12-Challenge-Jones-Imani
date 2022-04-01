package com.company;

public class City {
    protected String name;
    protected int population;
    protected String state;
    protected boolean capital;

    // constructor
    public City (String name, int population, String state, boolean capital) {
        this.name = name;
        this.population = population;
        this.state = state;
        this.capital = capital;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getState() {
        return state;
    }

    public boolean getCapital() {
        return capital;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

}
