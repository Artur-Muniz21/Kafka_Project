package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final ObjectMapper objectMapper;
    
    private Producer producer;

    public Consumer(ObjectMapper objectMapper, Producer producer) {
        this.objectMapper = objectMapper;
        this.producer = producer;
    }
    
//	@KafkaListener(topics = "teste", groupId = "my-group" )
//	public void receiveMessage(String message) {
//		System.out.println("Consumer Message: " + message);
//	}

    @KafkaListener(topics = "teste", groupId = "my-group")
    public void receiveFilteredMessage(String message) {
        if (message.startsWith("{")) {
            try {
                JsonNode jsonNode = objectMapper.readTree(message);
                
                if (jsonNode.has("tipo")) {
                    String tipo = jsonNode.get("tipo").asText();
                    if("produto".equals(tipo)) {
                    	Produto produto = new Produto(jsonNode.get("tipo").asText(), jsonNode.get("name").asText(), jsonNode.get("preco").asText());
                    	System.out.println("Produto");
                    	producer.sendMessageObj("produto", produto);
                    }
                } else {
                    System.out.println("Campo 'name' não encontrado na mensagem.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Falha ao processar a mensagem: " + e.getMessage());
            }
        } else {
        	System.out.println("Consumer Message: " + message);
        }
    }
}
