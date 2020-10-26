package com.accenture.myholdings.dao;
 
import org.springframework.data.repository.CrudRepository; 

import com.accenture.myholdings.model.FundHoldingId;
import com.accenture.myholdings.model.FundHoldings;  

//@Repository
//public interface FundHoldingService extends  JpaRepository<FundHoldings, FundHoldingsPK>  {
//public interface FundHoldingService extends  JpaRepository<FundHoldings, FundHoldingId>  {
public interface FundHoldingRepository extends  CrudRepository<FundHoldings, FundHoldingId>  {
	

	
	
}
