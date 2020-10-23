package com.accenture.myholdings.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.myholdings.model.FundHoldings; 
import com.accenture.myholdings.model.FundHoldingsPK; 

public interface FundHoldingService extends  CrudRepository<FundHoldings, FundHoldingsPK>  {

}
