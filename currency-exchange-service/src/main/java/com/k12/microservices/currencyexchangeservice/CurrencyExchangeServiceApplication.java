/**
 * The main file for the currency exchange service
 * @Author Derek Fermaint, K12
 * @Version 1.0
 */
package com.k12.microservices.currencyexchangeservice;

// Java Spring annotation imports
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // indicates the file as the application file
public class CurrencyExchangeServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
}
