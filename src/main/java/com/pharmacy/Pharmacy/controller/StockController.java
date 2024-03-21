package com.pharmacy.Pharmacy.controller;

import com.pharmacy.Pharmacy.dto.StockDTO;
import com.pharmacy.Pharmacy.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class StockController {
    private final StockService stockService;
    @GetMapping("/stock")
    public StockDTO getStock(@RequestParam(value = "pharmacy_branch_id", required = false) Long pharmacyBranchId,
                             @RequestParam(value = "medicine_id", required = false) Long medicineId) {

        return stockService.getStock(pharmacyBranchId, medicineId);
    }
}


