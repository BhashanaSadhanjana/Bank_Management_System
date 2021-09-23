package lk.epic.bankmanagemet.service;

import lk.epic.bankmanagemet.dto.CustomerDTO;
import java.util.ArrayList;


public interface CustomerService {

    void addCustomer(CustomerDTO dto);

    void deleteCustomer(int id);

    CustomerDTO searchCustomer(int id);

    void updateCustomer(CustomerDTO dto);

    ArrayList<CustomerDTO> getAllCustomers();
}
