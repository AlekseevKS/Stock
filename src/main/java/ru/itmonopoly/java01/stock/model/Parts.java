package ru.itmonopoly.java01.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Parts {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany()
    private List<Model> models;

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
