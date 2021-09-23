package lk.epic.bankmanagemet.dto;

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

public class CustomerDTO {

    private int cusId;
    private String cusFullName;
    private String email;
    private String dob;
    private String cusAddress;
    private String contact;

}
