package com.accenture.myholdings.dao;
 
import org.springframework.data.repository.CrudRepository; 

import com.accenture.myholdings.model.InvestorFunds;
import com.accenture.myholdings.model.InvestorFundsId;  


public interface InvestorFundRepository extends  CrudRepository<InvestorFunds, InvestorFundsId>   {
	

	
	
}
