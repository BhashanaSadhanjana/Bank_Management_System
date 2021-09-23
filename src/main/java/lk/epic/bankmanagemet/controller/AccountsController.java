package lk.epic.bankmanagemet.controller;


import lk.epic.bankmanagemet.dto.AccountsDTO;
import lk.epic.bankmanagemet.service.AccountsService;
import lk.epic.bankmanagemet.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/accounts")

public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @PostMapping(path = "/addAccount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveAccount(@RequestBody AccountsDTO dto) {

        accountsService.addAccount(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllAccounts() {
        ArrayList<AccountsDTO> allAcc = accountsService.getAllAccounts();
        return new ResponseEntity(new StandardResponse("200", "Done", allAcc), HttpStatus.OK);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAccounts(@RequestBody AccountsDTO dto) {
        accountsService.updateAccount(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAccounts(@RequestParam int id) {
        accountsService.deleteAccount(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchAccount(@PathVariable int id) {
        AccountsDTO accountsDTO = accountsService.searchAccount(id);
        return new ResponseEntity(new StandardResponse("200", "done", accountsDTO), HttpStatus.OK);
    }
}
