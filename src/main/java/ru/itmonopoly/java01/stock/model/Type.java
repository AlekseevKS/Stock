package ru.itmonopoly.java01.stock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type {
    public Type() {

    }
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getId() {
        return id;
    }

    @Column(name = "type_name")
    private String typeName;

    public Type(String typeName) {
        this.typeName = typeName;
    }


    public String getTypeName() {
        return typeName;
    }

}
