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

public class UserDTO {

    private int userId;
    private String userFullName;
    private String userContact;
    private String userEmail;
    private String userType;
    private String userPassword;

}
