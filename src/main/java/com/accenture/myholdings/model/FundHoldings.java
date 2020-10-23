package com.accenture.myholdings.model;
 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "fund_holdings")
@IdClass(FundHoldingsPK.class)
public @Data class FundHoldings implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 938330680735678065L;

	@Id
	@Column(name ="fund_id")
	private Long fundId;
	
	@Id
	@Column(name ="holdings_Id")
	private Long holdingsId;
	
	@Column(nullable = false)
	private Integer quantity;
	
	
	public Long getFundId() {
		return fundId;
	}
	public void setFundId(Long fundId) {
		this.fundId = fundId;
	}
	public Long getHoldingsId() {
		return holdingsId;
	}
	public void setHoldingsId(Long holdingId) {
		this.holdingsId = holdingId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	 
	
	
	
	
}
