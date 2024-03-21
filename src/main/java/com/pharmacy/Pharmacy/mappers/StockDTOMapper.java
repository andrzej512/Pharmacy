package com.pharmacy.Pharmacy.mappers;

import com.pharmacy.Pharmacy.dto.StockDTO;
import com.pharmacy.Pharmacy.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockDTOMapper {
    StockDTOMapper INSTANCE = Mappers.getMapper(StockDTOMapper.class);

    @Mapping(source = "onStock", target = "availableOnStock")
    StockDTO mapToStockDTO(Stock stock);
}
