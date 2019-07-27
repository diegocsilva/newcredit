package br.com.newcredit.service;

import br.com.newcredit.domain.MarginCredit;
import br.com.newcredit.dto.ProposalDTO;
import br.com.newcredit.dto.ResponseProposalDTO;
import br.com.newcredit.exception.RewiewReproveException;
import org.springframework.stereotype.Service;

import static br.com.newcredit.domain.Status.DENIED;

@Service
public class AgeRuleService extends Rule {
    @Override
    protected void rule(ProposalDTO proposal, ResponseProposalDTO response) {
        if (proposal.getAge() > 65 || proposal.getAge() < 18){
            response.setValue(response.getValue() - 500);
        }
    }

    @Override
    protected void newRewiewReproveException(ProposalDTO proposal, ResponseProposalDTO response) {
        response = ResponseProposalDTO.builder()
                .status(DENIED)
                .descriptionResult(MarginCredit.RENDA_BAIXA.getDescription())
                .cpf(proposal.getCpf())
                .marginCredit(MarginCredit.RENDA_BAIXA)
                .build();
        throw new RewiewReproveException(response);
    }
}
