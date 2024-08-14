package com.example.demo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Producer {

	private KafkaTemplate<String, String> kafkaTemplate;
	 private ObjectMapper objectMapper;

	public Producer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
		 this.objectMapper = new ObjectMapper();
	}
	
	public void sendMessage(String topic, String message) {
		kafkaTemplate.send(topic, message);
	}
	
    public void sendMessageObj(String topic, Produto produto) {
        try {
            String produtoJson = objectMapper.writeValueAsString(produto);
            kafkaTemplate.send(topic, produtoJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); 
        }
    }
		
	
}
