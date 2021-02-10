package com.example.codeclan.whiskytracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "whiskies")
public class Whisky {

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "distillery_id", nullable = false)
    @JsonIgnoreProperties({"whiskies"})
    private Distillery distillery;

    @Column
    private int year;

    @Column
    private int age;

    public Whisky(String name, Distillery distillery, int year, int age){
        this.name = name;
        this.distillery = distillery;
        this.year = year;
        this.age = age;
    }

    public Whisky(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Distillery getDistillery() {
        return distillery;
    }

    public void setDistillery(Distillery distillery) {
        this.distillery = distillery;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
