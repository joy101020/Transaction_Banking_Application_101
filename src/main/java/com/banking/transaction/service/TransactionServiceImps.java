package com.banking.transaction.service;

import com.banking.transaction.DTO.AccountWrapper;
import com.banking.transaction.DTO.AmountRequest;
import com.banking.transaction.DTO.TransferRequest;
import com.banking.transaction.client.AccountClient;
import com.banking.transaction.exception.TransactionNotFoundException;
import com.banking.transaction.model.Transaction;
import com.banking.transaction.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImps implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final AccountClient accountClient;

    public TransactionServiceImps(TransactionRepository transactionRepository, AccountClient accountClient) {
        this.transactionRepository = transactionRepository;
        this.accountClient = accountClient;
    }


    @Override
    public Transaction request(TransferRequest transferRequest) {
        accountClient.getAccountById(transferRequest.getSenderAccountId());

        accountClient.getAccountById(transferRequest.getReceiverAccountId());

        AmountRequest amountRequest = new AmountRequest();
        amountRequest.setBalance(transferRequest.getAmount());
        accountClient.debitAmount(transferRequest.getSenderAccountId(),amountRequest);
        accountClient.creditAmount(transferRequest.getReceiverAccountId(), amountRequest);

        Transaction transaction = new Transaction();
        transaction.setSenderAccountId(transferRequest.getSenderAccountId());
        transaction.setReceiverAccountId(transferRequest.getReceiverAccountId());
        transaction.setAmount(amountRequest.getBalance());
        transaction.setTransactionType("TRANSFER");
        transaction.setStatus("SUCCESS");
        transaction.setTransactionTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElseThrow(()->new TransactionNotFoundException("Transaction not found"));
    }

    @Override
    public List<Transaction> getTransactionByAccountId(Long accountId) {
        return transactionRepository.findBySenderAccountIdOrReceiverAccountId(accountId,accountId);
    }
}
