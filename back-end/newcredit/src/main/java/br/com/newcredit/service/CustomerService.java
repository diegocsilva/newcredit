package br.com.newcredit.service;

import br.com.newcredit.entity.Customer;
import br.com.newcredit.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void register(Customer customer) {
        repository.save(customer);
    }

    public Customer getByCpf(String cpf) {
        return repository.findCustomerByCpf(cpf);
    }
}
