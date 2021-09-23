package lk.epic.bankmanagemet.controller;

import lk.epic.bankmanagemet.dto.UserDTO;
import lk.epic.bankmanagemet.dto.UserIdDTO;
import lk.epic.bankmanagemet.service.UserService;
import lk.epic.bankmanagemet.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping(path = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDTO dto) {
        service.addUser(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/login")
    public ResponseEntity userLogin(@RequestParam String email, @RequestParam String password) {
        UserIdDTO userIdDTO = service.matchMail(email, password);
        return new ResponseEntity(new StandardResponse("202", "Done", userIdDTO), HttpStatus.ACCEPTED);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsers() {
        ArrayList<UserDTO> allUsers = service.getAllUsers();
        return new ResponseEntity(new StandardResponse("200", "Done", allUsers), HttpStatus.OK);

    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchUsers(@PathVariable int id) {
        UserDTO userDTO = service.searchUser(id);
        return new ResponseEntity(new StandardResponse("200", "done", userDTO), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUsers(@RequestParam int id) {
        service.deleteUser(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateUsers(@RequestBody UserDTO dto) {
        service.updateUser(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);

    }

    @PostMapping(path = "/searchUser/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchAllUsers(@PathVariable String name) {
        System.out.println(name);
        ArrayList<UserDTO> data = service.searchUsers(name);
        return new ResponseEntity(new StandardResponse("200", "Done", data), HttpStatus.OK);

    }


    @PutMapping(path = "/resetPassword")
    public ResponseEntity resetPassword(@RequestParam String email, @RequestParam String password) {
        service.resetPassword(email,password);
        System.out.println(email);
        System.out.println(password);
        return new ResponseEntity(new StandardResponse("202", "Done", null), HttpStatus.ACCEPTED);

    }

}
