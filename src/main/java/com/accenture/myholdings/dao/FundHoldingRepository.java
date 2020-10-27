package com.accenture.myholdings.dao;
 
import org.springframework.data.repository.CrudRepository; 

import com.accenture.myholdings.model.FundHoldingId;
import com.accenture.myholdings.model.FundHoldings;  

public interface FundHoldingRepository extends  CrudRepository<FundHoldings, FundHoldingId>  {
	

	
	
}
