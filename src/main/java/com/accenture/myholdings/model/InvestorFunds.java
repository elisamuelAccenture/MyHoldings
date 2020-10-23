package com.accenture.myholdings.model;
 

import lombok.Data;

 
public @Data class InvestorFunds {
	 
	private Long investorId; 
	private Long fundId;
	
	
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
