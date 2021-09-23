package lk.epic.bankmanagemet.service;

import lk.epic.bankmanagemet.dto.UserDTO;
import lk.epic.bankmanagemet.dto.UserIdDTO;

import java.util.ArrayList;

public interface UserService {

    void addUser(UserDTO dto);

    UserIdDTO matchMail (String email, String password);

    ArrayList<UserDTO> getAllUsers();

    void deleteUser(int id);

    UserDTO searchUser(int id);

    void updateUser(UserDTO dto);

    ArrayList<UserDTO> searchUsers(String search);

    void resetPassword(String Email,String password);

}
