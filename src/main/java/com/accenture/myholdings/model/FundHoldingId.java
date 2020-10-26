package com.accenture.myholdings.model;

 
  

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public @Data class FundHoldingId implements Serializable  { 
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 5972694822491728253L;

	@NotNull(message = "Value is required")
	private Long fundId;
	 
	@NotNull(message = "Value is required")
	private Long holding;

	
	
	
	public FundHoldingId(Long fundId, Long holding) {
		super();
		this.fundId = fundId;
		this.holding = holding;
	}


	public Long getHolding() {
		return holding;
	}


	public void setHolding(Long holding) {
		this.holding = holding;
	}


	public FundHoldingId() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	public Long getFundId() {
		return fundId;
	}

	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}

	 
 
 	
}
