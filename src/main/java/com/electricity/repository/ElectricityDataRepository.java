package com.electricity.repository;

import com.electricity.entity.ElectricityData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityDataRepository extends JpaRepository<ElectricityData, Long> {
}
