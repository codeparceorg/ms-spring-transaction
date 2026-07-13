package com.ms_spring_transferencias.lab.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_spring_transferencias.lab.dto.GetTransactionRequest;
import com.ms_spring_transferencias.lab.entity.Transaction;
import com.ms_spring_transferencias.lab.service.TransactionService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(
            TransactionService service) {
        this.service = service;
    }

    @PostMapping("get")
    public ResponseEntity<Transaction> get(@RequestBody GetTransactionRequest body) {
        Transaction response = service.get(body.getId(), body.getAccountNumber());
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("getAll")
    public ResponseEntity<List<Transaction>> getAll(@RequestBody GetTransactionRequest body) {
        
        List<Transaction> response = service.getAll(body.getAccountNumber(), body.getAccountNumber());

        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}