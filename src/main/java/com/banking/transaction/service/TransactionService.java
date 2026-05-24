package com.banking.transaction.service;

import com.banking.transaction.DTO.TransferRequest;
import com.banking.transaction.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction request(TransferRequest transferRequest);
    Transaction getTransactionById(Long id);
    List<Transaction> getTransactionByAccountId(Long accountId);
}
