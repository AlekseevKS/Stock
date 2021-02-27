package ru.itmonopoly.java01.stock.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
}
