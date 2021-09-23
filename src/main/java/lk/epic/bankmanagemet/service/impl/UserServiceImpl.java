package lk.epic.bankmanagemet.service.impl;

import lk.epic.bankmanagemet.dto.UserDTO;
import lk.epic.bankmanagemet.dto.UserIdDTO;
import lk.epic.bankmanagemet.entity.User;
import lk.epic.bankmanagemet.exception.ValidateException;
import lk.epic.bankmanagemet.repo.UserRepo;
import lk.epic.bankmanagemet.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addUser(UserDTO dto) {
        if (userRepo.existsByUserEmail(dto.getUserEmail())){
            throw new ValidateException("User Already Exists");
        }
        User user = modelMapper.map(dto, User.class);
        userRepo.save(user);
    }

    @Override
    public UserIdDTO matchMail(String email, String password) {

        User users = userRepo.getUserEmail(email);
        if (users.getUserPassword().equals(password)){
            return modelMapper.map(users,UserIdDTO.class);
        }else {

            throw new ValidateException("Please Provide Valid Creditionals");
        }
    }

    @Override
    public ArrayList<UserDTO> getAllUsers() {
        List<User> all = userRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<UserDTO>>(){}.getType());
    }

    @Override
    public void deleteUser(int id) {
        if (!userRepo.existsById(id)){
            throw new ValidateException("No User For Delete....!");
        }
        userRepo.deleteById(id);
    }

    @Override
    public UserDTO searchUser(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()){
            return modelMapper.map(user.get(),UserDTO.class);
        }
        return null;
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (userRepo.existsById(dto.getUserId())){
            userRepo.save(modelMapper.map(dto,User.class));
        }
    }

    @Override
    public ArrayList<UserDTO> searchUsers(String search) {
        /*List<User> allSearch =  userRepo.getUserName(search);*/
        List<User> allSearch =  userRepo.getAllByUserFullNameContaining(search);
        return modelMapper.map(allSearch, new TypeToken<ArrayList<UserDTO>>(){}.getType());
    }

    @Override
    public void resetPassword(String Email, String password) {

        if (userRepo.existsByUserEmail(Email)){

            userRepo.resetPassword(Email,password);
        }else {
            throw new ValidateException("This User Already Have An Account!");
        }
    }


}
