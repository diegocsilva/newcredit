package br.com.newcredit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NewCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewCreditApplication.class, args);
	}

}
