package com.accenture.myholdings.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.myholdings.model.Holding; 

public interface HoldingService extends  CrudRepository<Holding, Long>  {

}
