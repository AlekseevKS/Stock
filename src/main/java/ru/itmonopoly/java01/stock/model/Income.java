package ru.itmonopoly.java01.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Income {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @OneToMany(mappedBy = "income")
    private List<IncomeItem> items;
}
