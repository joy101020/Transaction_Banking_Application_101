package com.banking.transaction.controller;

import com.banking.transaction.DTO.TransferRequest;
import com.banking.transaction.model.Transaction;
import com.banking.transaction.service.TransactionServiceImps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionServiceImps transactionServiceImps;

    public TransactionController(TransactionServiceImps transactionServiceImps) {
        this.transactionServiceImps = transactionServiceImps;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> transferFunds(@RequestBody TransferRequest transferRequest) {
        return new ResponseEntity<>(transactionServiceImps.request(transferRequest), HttpStatus.OK);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransaction(@PathVariable Long transactionId) {
        return new ResponseEntity<>(transactionServiceImps.getTransactionById(transactionId), HttpStatus.OK);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getAccount(@PathVariable Long accountId) {
        return new ResponseEntity<>(transactionServiceImps.getTransactionByAccountId(accountId), HttpStatus.OK);
    }
}
