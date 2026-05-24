package com.banking.transaction.repository;

import com.banking.transaction.DTO.AccountWrapper;
import com.banking.transaction.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findBySenderAccountIdOrReceiverAccountId(Long senderId, Long receiverId);
}
