package com.pharmacy.Pharmacy.kafka;

import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.model.PharmacyBranch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, PharmacyBranch> kafkaTemplate;

    public void sendMessage(PharmacyBranchDTO harmacyBranchDTO) {
        LOGGER.info(String.format("Message sent -> %s", harmacyBranchDTO.toString()));

        Message<PharmacyBranchDTO> message = MessageBuilder
                .withPayload(harmacyBranchDTO)
                .setHeader(KafkaHeaders.TOPIC, "javaguides")
                .build();

        kafkaTemplate.send(message);
    }
}