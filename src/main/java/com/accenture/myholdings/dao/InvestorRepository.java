package com.accenture.myholdings.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.myholdings.model.Investor; 

public interface InvestorRepository extends  CrudRepository<Investor, Long>  {

}
