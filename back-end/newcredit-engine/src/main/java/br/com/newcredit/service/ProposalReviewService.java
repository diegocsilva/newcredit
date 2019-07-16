package br.com.newcredit.service;

import br.com.newcredit.domain.MarginCredit;
import br.com.newcredit.domain.Status;
import br.com.newcredit.dto.ProposalDTO;
import br.com.newcredit.dto.ResponseProposalDTO;
import org.springframework.stereotype.Service;

@Service
public class ProposalReviewService {

    private final AgeRuleService ageRuleService;
    private final DependsRuleService dependsRuleService;
    private final IncomeRuleService incomeRuleService;
    private final MaritalStatusRuleService maritalStatusRuleService;
    private final SexRuleService sexRuleService;

    public ProposalReviewService(AgeRuleService ageRuleService, DependsRuleService dependsRuleService,
                                 IncomeRuleService incomeRuleService, MaritalStatusRuleService maritalStatusRuleService,
                                 SexRuleService sexRuleService) {
        this.incomeRuleService = incomeRuleService;
        this.dependsRuleService = dependsRuleService;
        this.maritalStatusRuleService = maritalStatusRuleService;
        this.ageRuleService = ageRuleService;
        this.sexRuleService = sexRuleService;
    }

    public ResponseProposalDTO review(ProposalDTO proposal) {
        ResponseProposalDTO response = new ResponseProposalDTO();
        response.setValue(proposal.getIncome());

        incomeRuleService.executeRule(proposal, response);
        dependsRuleService.executeRule(proposal, response);
        maritalStatusRuleService.executeRule(proposal, response);
        ageRuleService.executeRule(proposal, response);
        sexRuleService.executeRule(proposal, response);
        return generateResponseApproved(proposal, response);
    }

    private ResponseProposalDTO generateResponseApproved(ProposalDTO proposal, ResponseProposalDTO response) {
        MarginCredit marginCredit = getMarginCreditByValue(response.getValue());
        return ResponseProposalDTO.builder()
                .marginCredit(marginCredit)
                .cpf(proposal.getCpf())
                .descriptionResult(marginCredit.getDescription())
                .status(Status.APPROVED)
                .build();
    }

    private MarginCredit getMarginCreditByValue(Double value){
        if (value >= 100 && value <= 500){
            return MarginCredit.ENTRE_100_A_500;
        }else if (value > 500 && value <= 1000){
            return MarginCredit.ENTRE_500_A_1000;
        }else if (value > 1000 && value <= 1500){
            return MarginCredit.ENTRE_1000_A_1500;
        }else if (value > 1500 && value <= 2000){
            return MarginCredit.ENTRE_1500_A_2000;
        }else if (value > 2000){
            return MarginCredit.SUPERIOR_A_2000;
        }else
            throw new RuntimeException("Erro ao verificar MarginCredit");
    }
}
