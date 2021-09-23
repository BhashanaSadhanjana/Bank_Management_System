package lk.epic.bankmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Accounts {

    @Id
    private int accId;
    private String accName;
    private String accOpenDate;
    private double defaultAmount;

    @ManyToOne
    @JoinColumn(name = "accTypeID", referencedColumnName = "accTypeId")
    private AccountType acType;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "cusId")
    private Customer customerId;


}
