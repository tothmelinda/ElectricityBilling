package com.electricity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO implements Serializable {

    private Long id;

    private String description;

    private Long totalAmount;

    private LocalDate dateIssued;

    private LocalDate dueDate;

    private LocalDate paidDate;

    private boolean isPaid;

    private String paymentMethod;

    private UserDTO user;

}
