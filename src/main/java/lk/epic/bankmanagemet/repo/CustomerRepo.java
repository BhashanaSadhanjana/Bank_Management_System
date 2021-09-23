package lk.epic.bankmanagemet.repo;

import lk.epic.bankmanagemet.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

}
