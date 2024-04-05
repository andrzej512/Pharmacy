package com.pharmacy.Pharmacy.controller;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody PharmacyBranchDTO pharmacyBranchDTO) {
        kafkaProducer.sendMessage(pharmacyBranchDTO);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
}