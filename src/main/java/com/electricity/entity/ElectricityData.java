package com.electricity.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ElectricityData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //a unique identifier for the electricity meter that was used
    @Column(name = "meter_id")
    private String meterId;

    // the date and time when the electricity meter was last read
    @Column(name = "start_date")
    private LocalDateTime startDate;

    //the date and time when the electricity meter was next read
    @Column(name = "end_date")
    private LocalDateTime endDate;

    //the meter reading at the start of the billing period
    @Column(name = "start_reading")
    private int startReading;

    //endReading: the meter reading at the end of the billing period
    @Column(name = "end_reading")
    private int endReading;

    //unitsUsed: the number of units of electricity used during the billing period
    @Column(name = "units_used")
    private int unitsUsed;

    //ratePerUnit: the cost per unit of electricity consumed
    @Column(name = "rate_per_unit")
    private BigDecimal ratePerUnit;

    //billAmount: the total amount due for the electricity usage during the billing period
    @Column(name = "bill_amount")
    private BigDecimal billAmount;
}
