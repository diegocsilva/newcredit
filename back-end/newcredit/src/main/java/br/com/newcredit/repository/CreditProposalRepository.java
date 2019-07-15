package br.com.newcredit.repository;

import br.com.newcredit.entity.CreditProposal;
import br.com.newcredit.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditProposalRepository extends JpaRepository<CreditProposal, Long> {

    CreditProposal findCreditProposalByCustomer_Cpf(String cpf);
}
