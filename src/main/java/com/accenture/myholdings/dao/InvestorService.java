package com.accenture.myholdings.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.myholdings.model.Investor; 

public interface InvestorService extends  CrudRepository<Investor, Long>  {

}
