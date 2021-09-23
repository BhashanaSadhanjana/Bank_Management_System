package lk.epic.bankmanagemet.repo;

import lk.epic.bankmanagemet.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface AccountsRepo extends JpaRepository<Accounts,Integer> {

    @Query(value = "select defaultAmount from accounts where accId=?1", nativeQuery = true)
    double getCurrentBalance(int balId);

    @Modifying
    @Query(value = "update Accounts set defaultAmount=?1 where accId=?2", nativeQuery = true)
    void updateCurrentBalance(double updatedAmount, int accountId);

    @Query(value = "select accTypeId from Accounts where accId=?1", nativeQuery = true)
    int getAccTypeId( int accountTypeId);



}
