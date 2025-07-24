package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootMsProj03ShoppingServiceConsumerAppFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsProj03ShoppingServiceConsumerAppFeignClientApplication.class, args);
	}

}
