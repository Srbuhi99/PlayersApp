package com.task.playersapp.network.models;

public class Team {
    private int id;

    private String abbreviation;

    private String city;

    private String conference;

    private String division;

    private String full_name;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getConference() {
        return this.conference;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDivision() {
        return this.division;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getFull_name() {
        return this.full_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
