package com.buyzilla.dev.code.service;

import com.buyzilla.dev.code.exceptions.CustomerAlreadyExistException;
import com.buyzilla.dev.code.exceptions.CustomerNotFoundException;
import com.buyzilla.dev.code.respository.CustomerRepository;
import com.buyzilla.dev.code.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void saveCustomer(List<com.buyzilla.dev.code.vo.Customer> customers) throws CustomerAlreadyExistException {
        for (com.buyzilla.dev.code.vo.Customer customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isPresent()) {
                throw new CustomerAlreadyExistException(customer.getCustomerID());
            }
            customerRepository.save(getEntity(customer));
        }
    }

    public void updateCustomer(List<com.buyzilla.dev.code.vo.Customer> customers) throws CustomerNotFoundException {
        for (com.buyzilla.dev.code.vo.Customer customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isEmpty()) {
                throw new CustomerNotFoundException(customer.getCustomerID());
            }
            customerRepository.save(getEntity(customer));
        }
    }

    public Customer getEntity(com.buyzilla.dev.code.vo.Customer customer){
        return Customer.builder()
                .customerName(customer.getCustomerName())
                .address(customer.getAddress())
                .postalCode(customer.getPostalCode())
                .city(customer.getCity())
                .country(customer.getCountry()).build();
    }

}
