package com.accenture.myholdings.model;

 
  

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public @Data class FundHoldingsPK implements Serializable  { 
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4674283133408383356L;

	private Long fundId;
	 
	private Long holdingsId;
	
 

 



	public FundHoldingsPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public FundHoldingsPK(Long fundId, Long holdingsId) {

		super();
		this.fundId = fundId;
		this.holdingsId = holdingsId; 
	}




	public Long getFundId() {
		return fundId;
	}

	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}

	public Long getHoldingsId() {
		return holdingsId;
	}

	public void setHoldingsId(Long holdingsId) {
		this.holdingsId = holdingsId;
	}
	
	
	
}
