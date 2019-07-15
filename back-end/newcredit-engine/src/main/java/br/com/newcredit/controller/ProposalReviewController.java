package br.com.newcredit.controller;

import br.com.newcredit.dto.ProposalDTO;
import br.com.newcredit.dto.ResponseProposalDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proposal-reviews")
public class ProposalReviewController {

    @PostMapping
    public ResponseEntity<?> review(ProposalDTO proposal){
        ResponseProposalDTO responseProposal = proposalReviewService.sendProposal(proposal);
        return ResponseEntity.ok(responseProposal);
    }
}
