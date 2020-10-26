package com.accenture.myholdings.model;
 

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

 
public @Data class InvestorFundsId implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1960564175695275705L;
	@NotNull(message = "Value is required")
	private Long investorId; 
	@NotNull(message = "Value is required")
	private Long fundId;
//	private Long fund;
	
	
	
	public Long getInvestorId() {
		return investorId;
	}
	public void setInvestorId(Long investorId) {
		this.investorId = investorId;
	}
	public Long getFundId() {
		return fundId;
	}
	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}
	 
	
	
	
}
