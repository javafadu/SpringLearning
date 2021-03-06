package com.tpe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tpe.repository.DBMessageRepository;
import com.tpe.repository.Repository;

@Component("whatsappService")
public class WhatsappService implements MessageService {
	
	
	// Dependency injection
	// Otomatik olarak bu nesneyi bu sinifa bagla
	
	/* 
	// 1- field injection en cok bu kullanilir
	@Autowired
	@Qualifier("dbRepository")
	private Repository repository; 
	*/
	
	/*
	// 2- Constructor injection
	private Repository repository;
	@Autowired
	public WhatsappService(Repository repository) {
		this.repository=repository;
	}
	*/
	
	
	
	// 3- Setter Injection
    @Autowired
    @Qualifier("dbRepository")
    private Repository repository;
    public void setRepository( Repository repository) {
        this.repository=repository;
    }
    

	
	
    @Override
	public String sentMessage() {
		
		repository.saveMessage("I am a Whatsapp Service, i sent a wa message");
		return "I am a Whatsapp Service, i sent a wa message";
	}

}
