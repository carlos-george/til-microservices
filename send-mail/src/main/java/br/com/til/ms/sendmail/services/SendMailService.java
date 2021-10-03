package br.com.til.ms.sendmail.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.til.ms.sendmail.adapter.dto.StudentDTO;

@Service
public class SendMailService {

	Logger logger = LoggerFactory.getLogger(SendMailService.class);
	
	@KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}",
			containerFactory = "concurrentKafkaListenerContainerFactory")
	public void sendMailListener(ConsumerRecord<String, StudentDTO> record) {
	    
		
		logger.info("Received Message:  " + record.partition());
		logger.info("E-Mail enviado com sucesso para " + record.value());
	}
}
