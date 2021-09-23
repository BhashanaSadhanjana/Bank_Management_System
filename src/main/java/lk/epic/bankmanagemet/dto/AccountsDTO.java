package lk.epic.bankmanagemet.dto;

import lk.epic.bankmanagemet.entity.AccountType;
import lk.epic.bankmanagemet.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class AccountsDTO {

    private int accId;
    private String accName;
    private String accOpenDate;
    private double defaultAmount;


    private AccountType acType;
    private Customer customerId;
}
