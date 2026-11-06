package com.siscont.stocks.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.siscont.stocks.entity.Stock;
import com.siscont.stocks.service.StockService;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:8080")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> listar() {
        return stockService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Stock> registrar(
            @RequestBody Stock stock) {

        return ResponseEntity.ok(stockService.guardar(stock));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> actualizar(
            @PathVariable Long id,
            @RequestBody Stock stock) {

        Stock existente = stockService.buscarPorId(id);

        existente.setProductoId(stock.getProductoId());
        existente.setLote(stock.getLote());
        existente.setFechaVencim(stock.getFechaVencim());
        existente.setStockActual(stock.getStockActual());

        return ResponseEntity.ok(stockService.guardar(existente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        stockService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}