package lk.epic.bankmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accTypeId;
    private String accType;

}
