package ru.itmonopoly.java01.stock.repo;

import org.springframework.data.repository.CrudRepository;
import ru.itmonopoly.java01.stock.model.Parts;

public interface PartRepository extends CrudRepository<Parts, Long> {
}
