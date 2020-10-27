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
@IdClass(InvestorFundsId .class)
public @Data class InvestorFunds implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -1229801264235164694L;
	
	@Id
	@Column(name ="investor_id")
	@NotNull(message = "Value is required")
	private Long investorId;
	
	
//	@NotNull(message = "Value is required")
//	private Long fundId;
	
	@Id
	@ManyToOne
	private Fund fund;
	
	
	public Long getInvestorId() {
		return investorId;
	}
	public void setInvestorId(Long investorId) {
		this.investorId = investorId;
	}
	public Fund getFund() {
		return fund;
	}
	public void setFund(Fund fund) {
		this.fund = fund;
	}
	public InvestorFunds(@NotNull(message = "Value is required") Long investorId, Fund fund) {
		super();
		this.investorId = investorId;
		this.fund = fund;
	}
	public InvestorFunds() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	
	
	
	
}
