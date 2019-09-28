package com.seu.miaosha.redis;

public interface KeyPrefix {
		
	int expireSeconds();
	
	String getPrefix();
	
}
