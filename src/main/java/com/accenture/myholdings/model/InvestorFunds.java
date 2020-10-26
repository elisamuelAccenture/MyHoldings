package com.accenture.myholdings.model;
 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity
@IdClass(InvestorFundsId.class)
@Table(name= "investor_funds")
public @Data class InvestorFunds implements Serializable {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -1229801264235164694L;


	@Id
	@Column(name="investor_id")
	@NotNull(message = "Value is required")
	private Long investorId; 
	
	
	@Id
	@Column(name="funds_id")
	@NotNull(message = "Value is required")
	private Long fundId;
	
	
//	@Id
//	@ManyToOne
//	private Fund fund;
	
	
	
	 
	public Long getInvestorId() {
		return investorId;
	}
	public InvestorFunds(@NotNull(message = "Value is required") Long investorId,
			@NotNull(message = "Value is required") Long fundId) {
		super();
		this.investorId = investorId;
		this.fundId = fundId;
	}
	public Long getFundId() {
		return fundId;
	}
	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}
	public void setInvestorId(Long investorId) {
		this.investorId = investorId;
	}
	 
	 
	public InvestorFunds() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	
	
}
