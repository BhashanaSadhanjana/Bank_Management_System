package lk.epic.bankmanagemet.dto;

import lk.epic.bankmanagemet.entity.Accounts;
import lk.epic.bankmanagemet.entity.TransactionType;
import lk.epic.bankmanagemet.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class TransactionDTO {

    private int tranId;
    private double tranAmount;
    private String tranDescription;
    private String tranDate;

    private TransactionType transactionType;
    private User userID;
    private Accounts accountsId;
}
