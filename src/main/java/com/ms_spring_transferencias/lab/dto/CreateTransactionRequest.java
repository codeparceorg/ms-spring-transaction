package com.ms_spring_transferencias.lab.dto;

import java.math.BigDecimal;

import com.ms_spring_transferencias.lab.types.TransactionType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTransactionRequest {

    private String accountNumber;
    private String destinationAccount;
    private TransactionType transactionType;
    private BigDecimal amount;
    private String description;



}
