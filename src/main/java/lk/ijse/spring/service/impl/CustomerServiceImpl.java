package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    @Autowired
    ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
      //  customerRepository.save (new Customer (dto.getId (),dto.getName (), dto.getAddress (), dto.getSalary ()));
        Customer customer = mapper.map (dto, Customer.class);
        customerRepository.save (customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById (id);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerRepository.findAll ();
        return mapper.map (all,new TypeToken<List<CustomerDTO>> (){}.getType ());
    }

    @Override
    public CustomerDTO findCustomer(String id) {
        Customer customer = customerRepository.findById (id).get ();
        return mapper.map (customer, CustomerDTO.class);
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        Customer customer = mapper.map (dto, Customer.class);
        customerRepository.save (customer);

    }
}
