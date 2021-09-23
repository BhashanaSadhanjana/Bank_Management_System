package lk.epic.bankmanagemet.service.impl;

import lk.epic.bankmanagemet.dto.AccountsDTO;
import lk.epic.bankmanagemet.entity.Accounts;
import lk.epic.bankmanagemet.exception.ValidateException;
import lk.epic.bankmanagemet.repo.AccountsRepo;
import lk.epic.bankmanagemet.service.AccountsService;
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
public class AccountsServiceImpl implements AccountsService {

    @Autowired
    private AccountsRepo accountsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addAccount(AccountsDTO dto) {
        if(accountsRepo.existsById(dto.getAccId())){
            throw new ValidateException("Account has Already Opened");
        }
        Accounts accounts = modelMapper.map(dto, Accounts.class);
        accountsRepo.save(accounts);
    }

    @Override
    public void deleteAccount(int id) {
        if(!accountsRepo.existsById(id)){
            throw new ValidateException("No Account For Deleting...!");
        }
        accountsRepo.deleteById(id);
    }

    @Override
    public AccountsDTO searchAccount(int id) {
        Optional<Accounts> account = accountsRepo.findById(id);
        if (account.isPresent()){
            return modelMapper.map(account.get(),AccountsDTO.class);
        }
        return null;
    }

    @Override
    public void updateAccount(AccountsDTO dto) {
        if (accountsRepo.existsById(dto.getAccId())){
            accountsRepo.save(modelMapper.map(dto,Accounts.class));
        }
    }

    @Override
    public ArrayList<AccountsDTO> getAllAccounts() {
        List<Accounts> all = accountsRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<AccountsDTO>>(){}.getType());
    }
}
