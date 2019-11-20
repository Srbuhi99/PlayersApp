package com.task.playersapp.network.models;

public class Data {
    private int id;

    private String first_name;

    private String height_feet;

    private String height_inches;

    private String last_name;

    private String position;

    private Team team;

    private String weight_pounds;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }
    public String getFirst_name(){
        return this.first_name;
    }
    public void setHeight_feet(String height_feet){
        this.height_feet = height_feet;
    }
    public String getHeight_feet(){
        return this.height_feet;
    }
    public void setHeight_inches(String height_inches){
        this.height_inches = height_inches;
    }
    public String getHeight_inches(){
        return this.height_inches;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }
    public String getLast_name(){
        return this.last_name;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public String getPosition(){
        return this.position;
    }
    public void setTeam(Team team){
        this.team = team;
    }
    public Team getTeam(){
        return this.team;
    }
    public void setWeight_pounds(String weight_pounds){
        this.weight_pounds = weight_pounds;
    }
    public String getWeight_pounds(){
        return this.weight_pounds;
    }
}
