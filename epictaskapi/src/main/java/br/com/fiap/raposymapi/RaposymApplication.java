package br.com.fiap.raposymapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RaposymApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaposymApplication.class, args);
	}

}
