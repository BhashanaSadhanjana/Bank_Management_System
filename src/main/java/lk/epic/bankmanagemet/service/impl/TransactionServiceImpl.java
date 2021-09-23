package lk.epic.bankmanagemet.service.impl;


import lk.epic.bankmanagemet.dto.TransactionDTO;
import lk.epic.bankmanagemet.entity.Accounts;
import lk.epic.bankmanagemet.entity.Transaction;
import lk.epic.bankmanagemet.entity.TransactionType;
import lk.epic.bankmanagemet.exception.ValidateException;
import lk.epic.bankmanagemet.repo.AccountsRepo;
import lk.epic.bankmanagemet.repo.TransactionRepo;
import lk.epic.bankmanagemet.service.TransactionService;
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
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private AccountsRepo accountsRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void handleTransaction(TransactionDTO transactionDTO) {

        Accounts account = transactionDTO.getAccountsId();

        double currentBal = accountsRepo.getCurrentBalance(account.getAccId());
        double newTranAmount = transactionDTO.getTranAmount();
        int accTypeId = accountsRepo.getAccTypeId(account.getAccId());
        TransactionType transactionType = transactionDTO.getTransactionType();
        int tranTypeId = transactionType.getTranTypeId();

        if (accTypeId == 1) {
            System.out.println("Saving");

            if (tranTypeId == 1) {

                if (newTranAmount < currentBal - 500.00) {

                    System.out.println(currentBal - 500.00);
                    System.out.println(newTranAmount);
                    double updateAmount = currentBal - newTranAmount;
                    accountsRepo.updateCurrentBalance(updateAmount, account.getAccId());
                    transactionRepo.save(modelMapper.map(transactionDTO, Transaction.class));
                } else {

                    throw new ValidateException("Insufficent AccountBalance");
                }
                //saving acccount money deposit

            } else if (tranTypeId == 2) {
                System.out.println("else if");

                double updateAmount = currentBal + newTranAmount;
                accountsRepo.updateCurrentBalance(updateAmount, account.getAccId());
                transactionRepo.save(modelMapper.map(transactionDTO, Transaction.class));

                //for account money tranfer

            } else {

                System.out.println("else");
                if (newTranAmount < currentBal) {


                }
            }


        } else {

            System.out.println("current");


            if (tranTypeId == 1) {
                if (newTranAmount < currentBal - 2000.00) {
                    System.out.println(currentBal - 2000.00);
                    System.out.println(newTranAmount);
                    double updateAmount = currentBal - newTranAmount;
                    accountsRepo.updateCurrentBalance(updateAmount, account.getAccId());
                    transactionRepo.save(modelMapper.map(transactionDTO, Transaction.class));

                } else {

                    throw new ValidateException("Insufficent Account Balance");
                }

                // current account money deposit
            } else if (tranTypeId == 2) {
                System.out.println("else if");

                double updateAmount = currentBal + newTranAmount;
                accountsRepo.updateCurrentBalance(updateAmount, account.getAccId());
                transactionRepo.save(modelMapper.map(transactionDTO, Transaction.class));

                //current account money transfer
            } else {

                System.out.println("else");
                if (newTranAmount < currentBal) {
                    //////////////////////////////////////////////////

                }
            }
        }
    }

    @Override
    public ArrayList<TransactionDTO> getAllTransactions() {
        List<Transaction> all = transactionRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<TransactionDTO>>() {
        }.getType());
    }

    @Override
    public TransactionDTO searchTran(int id) {
        Optional<Transaction> transaction = transactionRepo.findById(id);
        if (transaction.isPresent()) {
            return modelMapper.map(transaction.get(), TransactionDTO.class);
        }
        return null;
    }

}
