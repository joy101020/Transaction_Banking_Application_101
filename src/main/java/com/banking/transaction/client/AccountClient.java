package com.banking.transaction.client;

import com.banking.transaction.DTO.AccountWrapper;
import com.banking.transaction.DTO.AmountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountClient {

    @PutMapping("/account/debit/{accountId}")
    AccountWrapper debitAmount(@PathVariable("accountId") Long accountId, @RequestBody AmountRequest amount);

    @PutMapping("/account/credit/{accountId}")
    AccountWrapper creditAmount( @PathVariable("accountId") Long accountId, @RequestBody AmountRequest amount);

    @GetMapping("/account/{accountId}")
    AccountWrapper getAccountById(@PathVariable("accountId") Long accountId);
}
