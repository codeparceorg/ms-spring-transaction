package com.ms_spring_transferencias.lab.service;

import com.ms_spring_transferencias.lab.dto.CreateTransactionRequest;
import com.ms_spring_transferencias.lab.entity.Transaction;

public interface TransactionService {
    
        Transaction create(CreateTransactionRequest request);

}
