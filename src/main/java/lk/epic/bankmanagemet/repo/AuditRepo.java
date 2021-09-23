package lk.epic.bankmanagemet.repo;

import lk.epic.bankmanagemet.entity.Audits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditRepo extends JpaRepository<Audits,Integer> {

    List<Audits>getAllByAuditTypeContaining(String auditType);
}
