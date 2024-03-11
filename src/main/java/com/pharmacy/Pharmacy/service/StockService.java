package com.pharmacy.Pharmacy.service;

import com.pharmacy.Pharmacy.dto.StockDTO;
import com.pharmacy.Pharmacy.mappers.StockDTOMapper;
import com.pharmacy.Pharmacy.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public StockDTO getStock(Long pharmacyBranchId, Long medicineId){

        return StockDTOMapper.INSTANCE.mapToStockDTO(stockRepository.findByPharmacyBranchId_IdAndMedicineId_Id(pharmacyBranchId,medicineId));

    }
}
