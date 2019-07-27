package br.com.newcredit.service;

import br.com.newcredit.entity.CreditProposal;
import br.com.newcredit.repository.CreditProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<CreditProposal> proposals = repository.findAllByCustomer_CpfOrderById(cpf);
        return proposals.size()>0 ? proposals.get(0) : new CreditProposal();
    }
}
