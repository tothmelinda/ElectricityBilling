package com.electricity.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Long totalAmount;

    private LocalDate dateIssued;

    private LocalDate dueDate;

    private LocalDate paidDate;

    private Boolean isPaid;

    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
