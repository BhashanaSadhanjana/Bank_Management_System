package lk.epic.bankmanagemet.service.impl;

import lk.epic.bankmanagemet.dto.CustomerDTO;
import lk.epic.bankmanagemet.entity.Customer;
import lk.epic.bankmanagemet.exception.ValidateException;
import lk.epic.bankmanagemet.repo.CustomerRepo;
import lk.epic.bankmanagemet.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService{

   @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCusId())){
            throw new ValidateException("Customer Already Exists");
        }
        Customer customer = modelMapper.map(dto, Customer.class);
        customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        if (!customerRepo.existsById(id)){
            throw new ValidateException("No Customer For Deleting...!");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public CustomerDTO searchCustomer(int id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()){
            return modelMapper.map(customer.get(),CustomerDTO.class);
        }
        return null;
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCusId())){
            customerRepo.save(modelMapper.map(dto,Customer.class));
        }
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return modelMapper.map(all, new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }
}
