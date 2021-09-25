package br.com.til.ms.sendmail.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapAddress;
	
//	 @Bean
//	    public KafkaAdmin kafkaAdmin() {
//	        Map<String, Object> configs = new HashMap<>();
//	        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//	        return new KafkaAdmin(configs);
//	    }
//	    
//	    @Bean
//	    public NewTopic topicSendMail() {
//	         return new NewTopic("send-mail", 2, (short) 1);
//	    }
}
