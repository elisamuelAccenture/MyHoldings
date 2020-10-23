package com.accenture.myholdings.model;
 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id; 
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity 
public @Data class Fund  {
	 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Long id;


	@Column(unique = true, nullable = false )
	private String name;
	 
	private double marketValue;

	@OneToMany(cascade =  CascadeType.ALL )
	private List<Holding> holdings;
	

	public double getMarketValue() {
		
		marketValue = holdings.stream().mapToDouble(v -> v.getValue() ).sum();
		
		return marketValue;
	}

	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Holding> getHoldings() {
		return holdings;
	}

	public void setHoldings(List<Holding> holdings) {
		this.holdings = holdings;
	}
	
	
	

}
