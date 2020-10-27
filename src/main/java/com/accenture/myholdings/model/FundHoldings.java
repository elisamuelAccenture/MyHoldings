package com.accenture.myholdings.model;
 

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass; 
import javax.persistence.ManyToOne; 
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity
@IdClass(FundHoldingId .class)
public @Data class FundHoldings implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 938330680735678065L;

	@Id
	@Column(name ="fund_id")
	@NotNull(message = "Value is required")
	private Long fundId;


	
	@Id
	@ManyToOne
	private Holding holding;
	
	
	
	private Integer quantity=0;


	
	public FundHoldings() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 


	public Holding getHolding() {
		return holding;
	}




	public void setHolding(Holding holding) {
		this.holding = holding;
	}




	public Long getFundId() {
		return fundId;
	}
	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}
	 
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	 
	
	 
	public FundHoldings(@NotNull(message = "Value is required") Long fundId, Holding holding, Integer quantity) {
		super();
		this.fundId = fundId;
		this.holding = holding;
		this.quantity = quantity;
	}
	
	
	
	
}
