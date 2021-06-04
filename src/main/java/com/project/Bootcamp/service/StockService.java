package com.project.Bootcamp.service;

import com.project.Bootcamp.exceptions.BusinessException;
import com.project.Bootcamp.exceptions.NotFoundExceptions;
import com.project.Bootcamp.mapper.StockMapper;
import com.project.Bootcamp.model.Stock;
import com.project.Bootcamp.model.dto.StockDTO;
import com.project.Bootcamp.repository.StockRepository;
import com.project.Bootcamp.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;
    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(dto.getName(), dto.getDate());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNameAndDateAndId(dto.getName(), dto.getDate(), dto.getId());
        if(optionalStock.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(id);
        return dto;
    }

    @Transactional
    public List<StockDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundExceptions::new);
    }

    @Transactional
    public List<StockDTO> findByDate() {
        return repository.findByDate(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundExceptions::new);
    }
}
