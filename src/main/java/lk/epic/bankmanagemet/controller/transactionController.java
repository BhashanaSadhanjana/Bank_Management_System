package lk.epic.bankmanagemet.controller;


import lk.epic.bankmanagemet.dto.AccountsDTO;
import lk.epic.bankmanagemet.dto.TransactionDTO;
import lk.epic.bankmanagemet.service.TransactionService;
import lk.epic.bankmanagemet.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/transaction")
public class transactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(path = "/activateTransaction", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@RequestBody TransactionDTO dto) {
        transactionService.handleTransaction(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllTrans() {
        ArrayList<TransactionDTO> allTran= transactionService.getAllTransactions();
        return new ResponseEntity(new StandardResponse("200", "Done", allTran), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchTran(@PathVariable int id) {
        TransactionDTO transactionDTO = transactionService.searchTran(id);
        return new ResponseEntity(new StandardResponse("200", "done", transactionDTO), HttpStatus.OK);
    }

}
