package com.api.prueba.services;

import com.api.prueba.model.Customer;
import com.api.prueba.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(Long id) {
      return customerRepository.findById(id);
   }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Transactional
    public void delete(Customer customer) {customerRepository.delete(customer);}
}
