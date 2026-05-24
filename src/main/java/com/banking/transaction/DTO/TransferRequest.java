package com.banking.transaction.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TransferRequest {
    private Long senderAccountId;
    private Long receiverAccountId;
    private  Double amount;
}
