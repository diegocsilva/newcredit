package br.com.newcredit.service;

import br.com.newcredit.domain.Status;
import br.com.newcredit.dto.ProposalDTO;
import br.com.newcredit.dto.ResponseProposalDTO;
import br.com.newcredit.entity.CreditProposal;
import br.com.newcredit.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class ProposalService {

    private final CustomerService customerService;
    private final NewCreditEngineService newCreditEngineService;
    private final CreditProposalService creditProposalService;

    public ProposalService(CustomerService customerService, NewCreditEngineService newCreditEngineService, CreditProposalService creditProposalService) {
        this.customerService = customerService;
        this.newCreditEngineService = newCreditEngineService;
        this.creditProposalService = creditProposalService;
    }

    public ResponseProposalDTO sendProposal(ProposalDTO proposal) {
        Customer customer = convertToCustomer(proposal);
        registerCustomer(customer);
        ResponseProposalDTO responseProposal = newCreditEngineService.review(proposal);
        CreditProposal creditProposal = convertToResponseProposalToCreditProposal(responseProposal);
        registerCreditProposal(creditProposal);
        return responseProposal;
    }

    public ResponseProposalDTO getProposal(String cpf) {
        CreditProposal creditProposal = creditProposalService.getProposalByCpf(cpf);
        return converCreditProposalToResponseProposalDTO(creditProposal);
    }

    private void registerCustomer(Customer customer) {
        customerService.register(customer);
    }

    private void registerCreditProposal(CreditProposal creditProposal) {
        creditProposalService.register(creditProposal);
    }

    private Customer convertToCustomer(ProposalDTO proposal) {
        return Customer.builder()
                .cpf(proposal.getCpf())
                .name(proposal.getName())
                .age(proposal.getAge())
                .dependents(proposal.getDependents())
                .income(proposal.getIncome())
                .maritalStatus(proposal.getMaritalStatus())
                .sex(proposal.getSex())
                .state(proposal.getState())
                .build();
    }

    private CreditProposal convertToResponseProposalToCreditProposal(ResponseProposalDTO responseProposal) {
        String cpf = responseProposal.getCpf();
        Customer customer = customerService.getByCpf(cpf);
        return CreditProposal.builder()
                .customer(customer)
                .descriptionResult(responseProposal.getDescriptionResult())
                .margin(responseProposal.getMargin())
                .status(Status.valueOf(responseProposal.getStatus()))
                .build();
    }

    private ResponseProposalDTO converCreditProposalToResponseProposalDTO(CreditProposal creditProposal) {
        return ResponseProposalDTO.builder()
                .cpf(creditProposal.getCustomer().getCpf())
                .descriptionResult(creditProposal.getDescriptionResult())
                .status(creditProposal.getStatus().name())
                .margin(creditProposal.getMargin())
                .build();
    }
}
