package lk.epic.bankmanagemet.service.impl;

import lk.epic.bankmanagemet.dto.AuditsDTO;
import lk.epic.bankmanagemet.entity.Audits;
import lk.epic.bankmanagemet.exception.ValidateException;
import lk.epic.bankmanagemet.repo.AuditRepo;
import lk.epic.bankmanagemet.service.AuditService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditServiceImpl implements AuditService {

    @Autowired
    private AuditRepo auditRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addAudit(AuditsDTO dto) {
        if (auditRepo.existsById(dto.getAuditId())){
           throw new ValidateException("Audit all ready Exists");
        }
        Audits audits = modelMapper.map(dto,Audits.class);
        auditRepo.save(audits);

    }

    @Override
    public AuditsDTO searchAudit(int id) {
        Optional<Audits> audits = auditRepo.findById(id);
        if (audits.isPresent()){
            return modelMapper.map(audits.get(),AuditsDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<AuditsDTO> getAllAudits() {
        List<Audits> all = auditRepo.findAll();
        return modelMapper.map(all,new TypeToken<ArrayList<AuditsDTO>>(){}.getType());
    }

    @Override
    public ArrayList<AuditsDTO> searchAudits(String search) {
        List<Audits> searchAudit = auditRepo.getAllByAuditTypeContaining(search);
        return modelMapper.map(searchAudit,new TypeToken<ArrayList<AuditsDTO>>(){}.getType());
    }
}
