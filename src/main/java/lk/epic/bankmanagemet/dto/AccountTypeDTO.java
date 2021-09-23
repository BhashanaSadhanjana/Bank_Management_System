package lk.epic.bankmanagemet.dto;

import lk.epic.bankmanagemet.entity.AccountType;
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

public class AccountTypeDTO {

    private int accTypeId;
    private String accType;


}
