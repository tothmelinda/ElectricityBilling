package com.electricity.mapper;

import com.electricity.dto.ElectricityDataDTO;
import com.electricity.entity.ElectricityData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ElectricityDataMapper extends GeneralMapper<ElectricityDataDTO, ElectricityData>{
}
