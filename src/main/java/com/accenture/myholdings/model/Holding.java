package com.accenture.myholdings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Entity 
public @Data class Holding {
	 
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Long id;
	
	@Column(unique = true, nullable = false  )
	@NotNull(message = "Value is required")
	private String name;
	 
	@NotNull(message = "Value is required")
	@Positive
	@Max(value =(long) Double.MAX_VALUE )
	@Min(value = (long) 1D )
	private double value=0.0;

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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Holding(Long id, String name, double value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public Holding() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
