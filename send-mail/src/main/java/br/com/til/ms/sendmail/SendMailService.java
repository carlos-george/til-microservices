package br.com.til.ms.sendmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

	Logger logger = LoggerFactory.getLogger(SendMailService.class);
	
	@KafkaListener(id = "sendMailListener", topics = "topic.send.mail",
	        autoStartup = "${listen.auto.start:true}", concurrency = "${listen.concurrency:3}")
	public void sendMailListener(Long data) {
	    
		logger.info("E-Mail enviado com sucesso para " + data);
	}
}
