package com.banking.transaction.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountWrapper {
    private Long accountId;
    private String accountType;
    private Long customerId;
    private double balance;
}
