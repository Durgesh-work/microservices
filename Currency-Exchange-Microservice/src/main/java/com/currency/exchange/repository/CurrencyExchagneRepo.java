package com.currency.exchange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.exchange.entity.CurrencyExchange;

public interface CurrencyExchagneRepo extends JpaRepository<CurrencyExchange, Long> {

	public CurrencyExchange findByFromAndTo(String from, String to);
}
