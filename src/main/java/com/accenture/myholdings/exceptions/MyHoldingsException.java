package com.accenture.myholdings.exceptions;

import lombok.Data;

public @Data class MyHoldingsException  extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8988610563634941164L;
	

	public MyHoldingsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	} 
	
	
	
	
	
	

}
