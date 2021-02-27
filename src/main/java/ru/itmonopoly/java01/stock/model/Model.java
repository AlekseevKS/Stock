package ru.itmonopoly.java01.stock.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Model {
    public Model() {

    }
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(name = "vendor_code")
    private String vendorCode;

    @ManyToOne
    private Type type;

    @ManyToMany(mappedBy = "models")
    private List<Parts> parts;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public Type getType() {
        return type;
    }

    public List<Parts> getParts() {
        return parts;
    }
}
