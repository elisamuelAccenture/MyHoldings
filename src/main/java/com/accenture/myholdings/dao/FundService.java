package com.accenture.myholdings.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.myholdings.model.Fund;

public interface FundService extends  CrudRepository<Fund, Long>  {

}
