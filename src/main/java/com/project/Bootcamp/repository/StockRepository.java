package com.project.Bootcamp.repository;

import com.project.Bootcamp.model.Stock;
import com.project.Bootcamp.model.dto.StockDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByNameAndDate(String name, LocalDate date);

    Optional<Stock> findByNameAndDateAndId(String name, LocalDate date, Long id);

    Optional<List<Stock>> findByDate(LocalDate date);
}
