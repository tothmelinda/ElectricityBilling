package com.electricity.service.impl;

import com.electricity.dto.ElectricityDataDTO;
import com.electricity.entity.ElectricityData;
import com.electricity.mapper.ElectricityDataMapper;
import com.electricity.mapper.UserMapper;
import com.electricity.repository.ElectricityDataRepository;
import com.electricity.service.ElectricityDataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@Service
public class ElectricityDataServiceImpl implements ElectricityDataService {

    private final ElectricityDataRepository electricityDataRepository;

    private final ElectricityDataMapper electricityDataMapper;

    private final UserMapper userMapper;

    @Override
    public List<ElectricityDataDTO> findAll() {
        return electricityDataMapper.toDTOs(electricityDataRepository.findAll()) ;
    }

    @Override
    public ElectricityDataDTO getById(Long id) {
        ElectricityData electricityData =  electricityDataRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("ElectricityData with id %d not found", id)));
        return electricityDataMapper.toDTO(electricityData);
    }

    @Override
    public ElectricityDataDTO add(ElectricityDataDTO electricityDataDTO) {
        return electricityDataMapper.toDTO(electricityDataRepository.save(electricityDataMapper.toEntity(electricityDataDTO)));
    }

    @Override
    public ElectricityDataDTO update(Long id, ElectricityDataDTO electricityDataDTO) {

        ElectricityData oldElectricityData = electricityDataRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("ElectricityData with id %d not found", id)));

        oldElectricityData.setUser(userMapper.toEntity(electricityDataDTO.getUser()));
        oldElectricityData.setMeterId(electricityDataDTO.getMeterId());
        oldElectricityData.setStartDate(electricityDataDTO.getStartDate());
        oldElectricityData.setEndDate(electricityDataDTO.getEndDate());
        oldElectricityData.setStartReading(electricityDataDTO.getStartReading());
        oldElectricityData.setEndReading(electricityDataDTO.getEndReading());
        oldElectricityData.setUnitsUsed(electricityDataDTO.getUnitsUsed());
        oldElectricityData.setRatePerUnit(electricityDataDTO.getRatePerUnit());
        oldElectricityData.setBillAmount(electricityDataDTO.getBillAmount());
        electricityDataRepository.save(oldElectricityData);

        return electricityDataMapper.toDTO(oldElectricityData);
    }

    @Override
    public void deleteById(Long id) {
        electricityDataRepository.deleteById(id);
    }

}

