package lk.epic.bankmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tranId;
    private double tranAmount;
    private String tranDescription;
    private String tranDate;


    @ManyToOne
    @JoinColumn(name = "transactionTypeId", referencedColumnName = "tranTypeId")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userId")
    private User userID;

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "accId")
    private Accounts accountsId;


}
