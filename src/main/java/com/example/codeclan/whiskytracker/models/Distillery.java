package com.example.codeclan.whiskytracker.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "distilleries")
public class Distillery {

    @Column
    private String name;

    @Column
    private String region;

    @OneToMany(mappedBy = "distillery")
    @JsonIgnoreProperties({"distillery"})
    private List<Whisky> whiskies;

    public Distillery(String name, String region){
        this.name = name;
        this.region = region;
        this.whiskies = new ArrayList<>();
    }

    public Distillery(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Whisky> getWhiskies() {
        return whiskies;
    }

    public void setWhiskies(List<Whisky> whiskies) {
        this.whiskies = whiskies;
    }
}
