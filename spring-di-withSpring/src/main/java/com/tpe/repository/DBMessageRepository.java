package com.tpe.repository;

import org.springframework.stereotype.Component;

@Component("dbRepository")
public class DBMessageRepository implements Repository{
	
	public void saveMessage(String message) {
		System.out.println("I am saving the message in DB");
	}

}
