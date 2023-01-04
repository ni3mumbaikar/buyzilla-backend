package com.buyzilla.dev.code.service;

import com.buyzilla.dev.code.exceptions.CustomerAlreadyExistException;
import com.buyzilla.dev.code.exceptions.CustomerNotFoundException;
import com.buyzilla.dev.code.respository.CustomerRepository;
import com.buyzilla.dev.code.entity.Customer;
import com.buyzilla.dev.code.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@PropertySource("classpath:eng_exceptions.properties")
@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    Environment environment;

    public List<Customer> getCustomers() {
        String query = "select * from customers";
        return customerRepository.findAll();
    }

    public void saveCustomer(List<CustomerVo> customerVos) throws CustomerAlreadyExistException {
        for (CustomerVo customerVo : customerVos) {
            if (customerRepository.findById(customerVo.getCustomerID()).isPresent()) {
                throw new CustomerAlreadyExistException(environment.getProperty("customer_already_exist"));
            }
            customerRepository.save(getEntity(customerVo));
        }
    }

    public void updateCustomer(List<CustomerVo> customerVos) throws CustomerNotFoundException {
        for (CustomerVo customerVo : customerVos) {
            if (customerRepository.findById(customerVo.getCustomerID()).isEmpty()) {
                throw new CustomerNotFoundException(environment.getProperty("customer_not_found"));
            }
            customerRepository.save(getEntity(customerVo));
        }
    }

    public Customer getEntity(CustomerVo customerVo) {
        return Customer.builder()
                .customerName(customerVo.getCustomerName())
                .address(customerVo.getAddress())
                .postalCode(customerVo.getPostalCode())
                .city(customerVo.getCity())
                .country(customerVo.getCountry()).build();
    }

    public void deleteCustomer(Integer cid) {
        customerRepository.delete(customerRepository.findById(cid).orElseThrow(()-> new CustomerNotFoundException(environment.getProperty("customer_not_found"))));
    }
}
