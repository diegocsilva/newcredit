package br.com.newcredit.service;

import br.com.newcredit.domain.MarginCredit;
import br.com.newcredit.dto.ProposalDTO;
import br.com.newcredit.dto.ResponseProposalDTO;
import br.com.newcredit.exception.RewiewReproveException;
import org.springframework.stereotype.Service;

import static br.com.newcredit.domain.Status.DENIED;

@Service
public class DependsRuleService extends Rule {
    @Override
    protected void rule(ProposalDTO proposal, ResponseProposalDTO response) {
        Double value = response.getValue() / proposal.getDependents() + 1;
        response.setValue(value);
    }

    @Override
    protected void newRewiewReproveException(ProposalDTO proposal, ResponseProposalDTO response) {
        response = ResponseProposalDTO.builder()
                .status(DENIED)
                .descriptionResult(MarginCredit.REPROVADO_PELA_POLITICA_DE_CREDITO.getDescription())
                .cpf(proposal.getCpf())
                .marginCredit(MarginCredit.REPROVADO_PELA_POLITICA_DE_CREDITO)
                .build();
        throw new RewiewReproveException(response);
    }
}
