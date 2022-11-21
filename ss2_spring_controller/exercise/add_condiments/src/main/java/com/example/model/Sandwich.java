package com.example.model;

public class Sandwich {
    private int id;
    private String name;
    private String condiments;

    public Sandwich() {
    }


    public Sandwich(int id, String name, String condiments) {
        this.id = id;
        this.name = name;
        this.condiments = condiments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondiments() {
        return condiments;
    }

    public void setCondiments(String condiments) {
        this.condiments = condiments;
    }
}
