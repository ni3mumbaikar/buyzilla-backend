package com.example.ecom.demo.service;

import com.example.ecom.demo.entity.Customer;
import com.example.ecom.demo.exceptions.CustomerAlreadyExistException;
import com.example.ecom.demo.exceptions.CustomerNotFoundException;
import com.example.ecom.demo.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    public void saveCustomer(List<Customer> customers) throws CustomerAlreadyExistException {
        for (Customer customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isPresent()) {
                throw new CustomerAlreadyExistException(customer.getCustomerID());
            }
            customerRepository.save(customer);
        }
    }

    public void updateCustomer(List<Customer> customers) throws CustomerNotFoundException {
        for (Customer customer : customers) {
            if (customerRepository.findById(customer.getCustomerID()).isEmpty()) {
                throw new CustomerNotFoundException(customer.getCustomerID());
            }
            customerRepository.save(customer);
        }
    }

}
