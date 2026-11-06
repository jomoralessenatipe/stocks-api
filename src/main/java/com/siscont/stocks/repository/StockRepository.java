package com.siscont.stocks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siscont.stocks.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}