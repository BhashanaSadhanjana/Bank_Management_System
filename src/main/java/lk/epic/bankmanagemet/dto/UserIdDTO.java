package lk.epic.bankmanagemet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserIdDTO {

    private int userId;
    private String userFullName;
    private String userEmail;
    private String userType;

}
