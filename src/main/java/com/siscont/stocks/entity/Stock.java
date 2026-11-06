package com.siscont.stocks.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "STOCK")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "PRODUCTO_ID", nullable = false)
    private Long productoId;

    @Column(name = "LOTE", length = 50)
    private String lote;

    @Column(name = "FECHA_VENCIM")
    private LocalDate fechaVencim;

    @Column(name = "STOCK_ACTUAL")
    private Integer stockActual;

    public Stock() {
    }

    public Stock(Long productoId, String lote, LocalDate fechaVencim,
                 Integer stockActual) {
        this.productoId = productoId;
        this.lote = lote;
        this.fechaVencim = fechaVencim;
        this.stockActual = stockActual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public LocalDate getFechaVencim() {
        return fechaVencim;
    }

    public void setFechaVencim(LocalDate fechaVencim) {
        this.fechaVencim = fechaVencim;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }
}