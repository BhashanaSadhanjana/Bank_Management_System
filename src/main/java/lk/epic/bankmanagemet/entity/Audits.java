package lk.epic.bankmanagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Audits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auditId;
    private String auditDate;
    private String auditTime;
    private String auditType;
    private String auditDesc;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User userId;

}
