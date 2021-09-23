package lk.epic.bankmanagemet.controller;


import lk.epic.bankmanagemet.dto.AccountsDTO;
import lk.epic.bankmanagemet.dto.AuditsDTO;
import lk.epic.bankmanagemet.dto.UserDTO;
import lk.epic.bankmanagemet.service.AuditService;
import lk.epic.bankmanagemet.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("api/v1/audits")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PostMapping(path = "/addAudit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveAudit(@RequestBody AuditsDTO dto) {

         auditService.addAudit(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllAudits() {
        ArrayList<AuditsDTO> allAudit = auditService.getAllAudits();
        return new ResponseEntity(new StandardResponse("200", "Done", allAudit), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchAudit(@PathVariable int id) {
        AuditsDTO auditsDTO= auditService.searchAudit(id);
        return new ResponseEntity(new StandardResponse("200", "done", auditsDTO), HttpStatus.OK);
    }

    @PostMapping(path = "/searchAudit/{audit}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchAllAudits(@PathVariable String audit) {
//        System.out.println(name);
        ArrayList<AuditsDTO> data = auditService.searchAudits(audit);
        return new ResponseEntity(new StandardResponse("200", "Done", data), HttpStatus.OK);

    }
}
