package br.com.til.ms.sendmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableEurekaClient
@EnableKafka
public class SendMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendMailApplication.class, args);
	}

}
