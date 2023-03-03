package com.electricity.dto;

import com.electricity.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElectricityDataDTO {

    private Long id;

    private User user;

    private String meterId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private int startReading;

    private int endReading;

    private int unitsUsed;

    private BigDecimal ratePerUnit;

    private BigDecimal billAmount;

}
