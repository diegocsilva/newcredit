package br.com.newcredit.controller;

import br.com.newcredit.dto.ProposalDTO;
import br.com.newcredit.dto.ResponseProposalDTO;
import br.com.newcredit.exception.RewiewReproveException;
import br.com.newcredit.service.ProposalReviewService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/api/proposal-reviews",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class ProposalReviewController {

    private final ProposalReviewService proposalReviewService;

    public ProposalReviewController(ProposalReviewService proposalReviewService) {
        this.proposalReviewService = proposalReviewService;
    }

    @PostMapping
    public ResponseEntity<?> review(@RequestBody ProposalDTO proposal){
        ResponseProposalDTO responseProposal = proposalReviewService.review(proposal);
        return ResponseEntity.ok(responseProposal);
    }

    @ExceptionHandler(RewiewReproveException.class)
    protected ResponseEntity<Object> handleDuplicatedCostDatabase(RewiewReproveException exception) {
        return ResponseEntity.ok(exception.getResponse());
    }

}
