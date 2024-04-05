package com.pharmacy.Pharmacy.kafka;


import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "javaguides",
            groupId = "group_id")
    public void consume(PharmacyBranchDTO pharmacyBranchDTO) {
        LOGGER.info(String.format("Message received -> %s", pharmacyBranchDTO.toString()));
    }
}