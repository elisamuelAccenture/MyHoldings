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
import lombok.Data;

@Entity 
public  @Data class Investor {
	  
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	

	@NotBlank(message = "Investor Name is required")
	@Column(unique = true, nullable = false )
	private String name;
	
	@OneToMany( cascade =  CascadeType.REMOVE , orphanRemoval = true )
	@JoinColumn(name = "investor_id")
	private List<InvestorFunds> investorFunds;



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

	public List<InvestorFunds> getInvestorFunds() {
		return investorFunds;
	}

	public void setInvestorFunds(List<InvestorFunds> investorFunds) {
		this.investorFunds = investorFunds;
	}
 
	
	

}
