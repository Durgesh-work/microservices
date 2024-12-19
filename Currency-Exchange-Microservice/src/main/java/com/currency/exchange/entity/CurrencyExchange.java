package com.currency.exchange.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchange {
	@Id
	private Long id;
	@Column(name =  "currency_from")
	private String from;
	@Column(name =  "currency_to")
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
	
	
	
	
}
