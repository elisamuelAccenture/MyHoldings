package com.accenture.myholdings.model;
 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
 
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity 
public @Data class Fund  {
	 
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	private Long id;

 
	@NotBlank(message = "Fund NAME is required")
	@Column(unique = true, nullable = false )
	private String name;


	private double marketValue;

//	@OneToMany(cascade =  CascadeType.ALL )
//	private List<Holding> holdings;

	@OneToMany( cascade =  CascadeType.REMOVE , orphanRemoval = true )
	@JoinColumn(name = "fund_Id")
	private List<FundHoldings> fundHoldings;
	
	@OneToMany( cascade =  CascadeType.REMOVE , orphanRemoval = true )
	@JoinColumn(name = "funds_Id")
	private List<InvestorFunds> invFunds;
	
	


	public List<InvestorFunds> getInvFunds() {
		return invFunds;
	}



	public void setInvFunds(List<InvestorFunds> invFunds) {
		this.invFunds = invFunds;
	}



	public List<FundHoldings> getFundHoldings() {
		return fundHoldings;
	}



	public void setFundHoldings(List<FundHoldings> fundHoldings) {
		this.fundHoldings = fundHoldings;
	}


	@JsonProperty
	public double getMarketValue() {
		if(fundHoldings!=null)
		{
			marketValue = fundHoldings.stream().mapToDouble(v -> (					
					v.getQuantity() * v.getHolding().getValue()) ).sum();
		}

		
		return marketValue;
	}

	
	public void setMarketValue(double marketValue) {
		this.marketValue = marketValue;
	}


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
 
	

}
