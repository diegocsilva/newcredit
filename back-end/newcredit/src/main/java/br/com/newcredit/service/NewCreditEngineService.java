package br.com.newcredit.service;

import br.com.newcredit.dto.ProposalDTO;
import br.com.newcredit.dto.ResponseProposalDTO;
import br.com.newcredit.entity.CreditProposal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "newCreditEngineService",
        url = "${application.newCreditEngine.url}")
public  interface NewCreditEngineService {

    @PostMapping
    ResponseProposalDTO review(@RequestBody ProposalDTO proposal);
}