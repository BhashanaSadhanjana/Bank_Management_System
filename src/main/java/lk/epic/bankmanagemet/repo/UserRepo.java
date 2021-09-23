package lk.epic.bankmanagemet.repo;

import lk.epic.bankmanagemet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository <User, Integer> {

    @Query(value = "SELECT * FROM User WHERE userEmail=?1", nativeQuery = true)
    User getUserEmail(String userEmail);
    /*@Query(value = "Select * from user where  userFullName like'\"+userName+\"%'", nativeQuery = true)
    List<User> getUserName(String userName);*/
    List<User> getAllByUserFullNameContaining(String userName);
//    User getUserName(String userName);
    boolean existsByUserEmail (String email);

    @Modifying
    @Query(value = "update User set userPassword =?2 where userEmail=?1",nativeQuery = true)
    void resetPassword(String Email,String password);



}
