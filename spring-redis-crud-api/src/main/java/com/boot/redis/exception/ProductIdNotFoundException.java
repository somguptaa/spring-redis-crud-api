package com.boot.redis.exception;

public class ProductIdNotFoundException extends RuntimeException{

	public ProductIdNotFoundException() {
	}
	public ProductIdNotFoundException(String msg) {
		super(msg);
	}
	
}
