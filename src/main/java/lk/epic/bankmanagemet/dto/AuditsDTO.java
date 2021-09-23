package lk.epic.bankmanagemet.dto;

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

public class AuditsDTO {

    private int auditId;
    private String auditDate;
    private String auditTime;
    private String auditType;
    private String auditDesc;

    private User userId;

}
