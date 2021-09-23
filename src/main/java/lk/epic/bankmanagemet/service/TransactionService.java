package lk.epic.bankmanagemet.service;


import lk.epic.bankmanagemet.dto.AccountTypeDTO;
import lk.epic.bankmanagemet.dto.AccountsDTO;
import lk.epic.bankmanagemet.dto.TransactionDTO;
import lk.epic.bankmanagemet.entity.Accounts;

import java.util.ArrayList;

public interface TransactionService {

    void handleTransaction(TransactionDTO transactionDTO);

    ArrayList<TransactionDTO> getAllTransactions();

    TransactionDTO searchTran(int id);




}
