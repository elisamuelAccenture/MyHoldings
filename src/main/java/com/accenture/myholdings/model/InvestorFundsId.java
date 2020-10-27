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
	private Long fund;
	
	
	public Long getInvestorId() {
		return investorId;
	}
	public void setInvestorId(Long investorId) {
		this.investorId = investorId;
	}
	public Long getFund() {
		return fund;
	}
	public void setFund(Long fund) {
		this.fund = fund;
	}
	public InvestorFundsId(@NotNull(message = "Value is required") Long investorId,
			@NotNull(message = "Value is required") Long fund) {
		super();
		this.investorId = investorId;
		this.fund = fund;
	}
	public InvestorFundsId() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
}
