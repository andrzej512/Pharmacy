package com.pharmacy.Pharmacy.kafka;


import com.pharmacy.Pharmacy.dto.PharmacyBranchDTO;
import com.pharmacy.Pharmacy.service.PharmacyBranchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    PharmacyBranchService pharmacyBranchService;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "createPharmacyTopic",
            groupId = "group_id")
    public void consume(PharmacyBranchDTO pharmacyBranchDTO) {
        LOGGER.info(String.format("Message received -> %s", pharmacyBranchDTO.toString()));
        pharmacyBranchService.createPharmacyBranch(pharmacyBranchDTO);
        System.out.println("post msg received");
    }
}