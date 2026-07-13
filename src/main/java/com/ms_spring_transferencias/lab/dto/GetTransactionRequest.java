package com.ms_spring_transferencias.lab.dto;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetTransactionRequest {
    private String accountNumber;
    private UUID id;

}
