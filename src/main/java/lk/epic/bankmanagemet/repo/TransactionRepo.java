package lk.epic.bankmanagemet.repo;

import lk.epic.bankmanagemet.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction,Integer> {
}
