package br.com.newcredit.repository;

import br.com.newcredit.entity.CreditProposal;
import br.com.newcredit.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditProposalRepository extends JpaRepository<CreditProposal, Long> {

    List<CreditProposal> findAllByCustomer_CpfOrderById(String cpf);
}
