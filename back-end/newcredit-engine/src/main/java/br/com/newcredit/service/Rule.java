package br.com.newcredit.service;

import br.com.newcredit.dto.ProposalDTO;
import br.com.newcredit.dto.ResponseProposalDTO;

public abstract class Rule {

    protected abstract void rule(ProposalDTO proposal, ResponseProposalDTO response);

    protected abstract void newRewiewReproveException(ProposalDTO proposal, ResponseProposalDTO response);

    public void executeRule(ProposalDTO proposal, ResponseProposalDTO response){
        rule(proposal, response);
        creditIsStillEnough(proposal, response);
    }

    private void creditIsStillEnough(ProposalDTO proposal, ResponseProposalDTO response){
        if (response.getValue() < 100){
            newRewiewReproveException(proposal, response);
        }
    }
}
