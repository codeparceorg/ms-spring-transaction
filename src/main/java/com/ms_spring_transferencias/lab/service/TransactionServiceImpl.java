package com.ms_spring_transferencias.lab.service;

import org.springframework.stereotype.Service;

import com.ms_spring_transferencias.lab.dto.CreateTransactionRequest;
import com.ms_spring_transferencias.lab.entity.Transaction;
import com.ms_spring_transferencias.lab.repository.TransactionRepository;
import com.ms_spring_transferencias.lab.types.TransactionStatusType;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction create(CreateTransactionRequest request) {

        Transaction transaction = new Transaction();

        transaction.setAccountId(request.getAccountNumber());
        transaction.setDestinationAccount(request.getDestinationAccount());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setStatus(TransactionStatusType.pending);
        transaction.setAmount(request.getAmount());
        transaction.setDescription(request.getDescription());

        return repository.save(transaction);
    }

}