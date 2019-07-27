package br.com.newcredit.repository;

import br.com.newcredit.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByCpf(String cpf);
}
