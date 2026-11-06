package com.siscont.stocks.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siscont.stocks.entity.Stock;
import com.siscont.stocks.repository.StockRepository;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional(readOnly = true)
    public List<Stock> listar() {
        return stockRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Stock buscarPorId(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Stock no encontrado"));
    }

    @Transactional
    public Stock guardar(Stock stock) {
        return stockRepository.save(stock);
    }

    @Transactional
    public void eliminar(Long id) {
        stockRepository.deleteById(id);
    }
}