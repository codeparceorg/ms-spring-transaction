package com.ms_spring_transferencias.lab.service;

import java.util.List;
import java.util.UUID;

import com.ms_spring_transferencias.lab.dto.CreateTransactionRequest;
import com.ms_spring_transferencias.lab.entity.Transaction;

public interface TransactionService {

        Transaction create(CreateTransactionRequest request);

        Transaction get(UUID id, String AccountNumber);

        List<Transaction> getAll(String AccountNumber, String destinationAccount);

}
