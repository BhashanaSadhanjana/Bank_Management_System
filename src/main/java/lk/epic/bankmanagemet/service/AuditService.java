package lk.epic.bankmanagemet.service;

import lk.epic.bankmanagemet.dto.AuditsDTO;

import java.util.ArrayList;

public interface AuditService {

    void addAudit(AuditsDTO dto);

    AuditsDTO searchAudit(int id);

    ArrayList<AuditsDTO> getAllAudits();

    ArrayList<AuditsDTO>searchAudits(String search);
}
