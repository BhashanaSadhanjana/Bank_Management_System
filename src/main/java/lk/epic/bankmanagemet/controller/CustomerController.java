package lk.epic.bankmanagemet.controller;

import lk.epic.bankmanagemet.dto.CustomerDTO;
import lk.epic.bankmanagemet.service.CustomerService;
import lk.epic.bankmanagemet.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/registerCustomer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
        customerService.addCustomer(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCustomers() {
        ArrayList<CustomerDTO> allCus = customerService.getAllCustomers();
        return new ResponseEntity(new StandardResponse("200", "Done", allCus), HttpStatus.OK);

    }


    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchCustomers(@PathVariable int id) {
        CustomerDTO customerDTO = customerService.searchCustomer(id);
        return new ResponseEntity(new StandardResponse("200", "done", customerDTO), HttpStatus.OK);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCustomers(@RequestBody CustomerDTO dto) {
        customerService.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);

    }


    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteCustomers(@RequestParam int id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }


}
