package com.ms_spring_transferencias.lab.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Value("${server.commit}")
    private String Version;

    private final TransactionService service;

    public TransactionController(
            TransactionService service) {
        this.service = service;
    }

    @GetMapping("version")
    public ResponseEntity<HashMap<String, String>> get() {

        HashMap response = new HashMap<>();

        response.put("Version: ", Version);
        response.put("App: ", "ms-spring-transaction");
        response.put("new: ", "ms-spring");
        response.put("test: ", "ms-test");
        response.put("Message: ", "Welcom ! :D");

        return ResponseEntity.status(HttpStatus.OK).body(response);
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