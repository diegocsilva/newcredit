package br.com.newcredit.service;

import br.com.newcredit.entity.CreditProposal;
import br.com.newcredit.repository.CreditProposalRepository;
import org.springframework.stereotype.Service;

@Service
public class CreditProposalService {

    private final CreditProposalRepository repository;

    public CreditProposalService(CreditProposalRepository repository) {
        this.repository = repository;
    }

    public void register(CreditProposal creditProposal) {
        repository.save(creditProposal);
    }

    public CreditProposal getProposalByCpf(String cpf) {
        return repository.findCreditProposalByCustomer_Cpf(cpf);
    }
}
