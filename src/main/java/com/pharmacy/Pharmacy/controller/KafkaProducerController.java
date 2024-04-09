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

    @PostMapping("/pharmacy-branch")
    public ResponseEntity<String> createPharmacyBranch(@RequestBody PharmacyBranchDTO pharmacyBranchDTO) {
        kafkaProducer.sendMessage(pharmacyBranchDTO);
        return ResponseEntity.ok("MSG for Post sent to kafka topic");
    }

}