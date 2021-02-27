package ru.itmonopoly.java01.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Order order;

    @NotNull
    @ManyToOne
    private Parts part;

    @NotNull
    private Long count;
}
