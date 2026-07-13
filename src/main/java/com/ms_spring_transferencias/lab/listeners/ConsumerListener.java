package com.ms_spring_transferencias.lab.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms_spring_transferencias.lab.dto.CreateTransactionRequest;
import com.ms_spring_transferencias.lab.dto.GetTransactionRequest;
import com.ms_spring_transferencias.lab.entity.Transaction;
import com.ms_spring_transferencias.lab.service.TransactionService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ConsumerListener {
    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    private final TransactionService service;
    private final ObjectMapper objectMapper;

    public ConsumerListener(
            TransactionService service,
            ObjectMapper objectMapper) {
        this.service = service;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(groupId = "group-2", topics = "trfs-topic", containerFactory = "kafkaListenerContainerFactory")
    public void listener(String message) {

        try {
            CreateTransactionRequest request = objectMapper.readValue(message, CreateTransactionRequest.class);

            log.info("{}", request);

            service.create(request);

        } catch (JsonProcessingException e) {
            log.error("Error convirtiendo mensaje Kafka: {}", message, e);
        }

    }
       
}
