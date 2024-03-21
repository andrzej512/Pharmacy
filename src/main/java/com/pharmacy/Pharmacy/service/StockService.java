package com.pharmacy.Pharmacy.service;

import com.pharmacy.Pharmacy.dto.StockDTO;
import com.pharmacy.Pharmacy.mappers.StockDTOMapper;
import com.pharmacy.Pharmacy.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockDTO getStock(Long pharmacyBranchId, Long medicineId) {

        return StockDTOMapper.INSTANCE.mapToStockDTO(stockRepository.findByPharmacyBranchId_IdAndMedicineId_Id(pharmacyBranchId, medicineId));
    }
}
