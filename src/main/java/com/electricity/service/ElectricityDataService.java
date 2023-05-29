package com.electricity.service;

import com.electricity.dto.ElectricityDataDTO;

import java.util.List;

public interface ElectricityDataService {

    List<ElectricityDataDTO> findAll();

    ElectricityDataDTO getById(Long id);

    ElectricityDataDTO add(ElectricityDataDTO electricityDataDTO);

    ElectricityDataDTO update(Long id, ElectricityDataDTO electricityDataDTO);

    void deleteById(Long id);
}
