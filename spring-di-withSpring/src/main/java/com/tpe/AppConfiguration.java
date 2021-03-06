package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.tpe.thirdparty.ThirdPartyComponent;

@Configuration
@ComponentScan("com.tpe")
@PropertySource("classpath:application.properties")
// Bu package altindaki tum class lari tarayacak
// sayet class larin icinde ilgili spring annotation lari gorurse (component)
// bean olusturup container a ekleyecek
public class AppConfiguration {
	
	
	
	// ThirdParty bilesenleri Spring container tarafindan olusturulup Container a 
	// konmasi icin @Bean annotation kullandik
	@Bean
	public ThirdPartyComponent thirdPartyComponent() {
		return new ThirdPartyComponent();
	}
	

	


}
