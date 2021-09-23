package lk.epic.bankmanagemet.service;

import lk.epic.bankmanagemet.dto.AccountsDTO;

import java.util.ArrayList;

public interface AccountsService {

    void addAccount(AccountsDTO dto);

    void deleteAccount(int id);

    AccountsDTO searchAccount(int id);

    void updateAccount(AccountsDTO dto);

    ArrayList<AccountsDTO> getAllAccounts();
}
