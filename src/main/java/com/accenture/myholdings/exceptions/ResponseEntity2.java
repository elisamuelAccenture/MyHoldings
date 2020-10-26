package com.accenture.myholdings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntity2<T> extends ResponseEntity<T> {

	public ResponseEntity2(HttpStatus status) {
		super(status);
		// TODO Auto-generated constructor stub
	}

}
