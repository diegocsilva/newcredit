package br.com.newcredit.controller;

import br.com.newcredit.dto.ProposalDTO;
import br.com.newcredit.dto.ResponseProposalDTO;
import br.com.newcredit.service.ProposalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

    private final ProposalService proposalService;

    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    @PostMapping
    public ResponseEntity<?> send(ProposalDTO proposal){
        ResponseProposalDTO responseProposal = proposalService.sendProposal(proposal);
        return ResponseEntity.ok(responseProposal);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> getProposalByCpf(@PathVariable("cpf") String cpf){
        ResponseProposalDTO responseProposal = proposalService.getProposal(cpf);
        return ResponseEntity.ok(responseProposal);
    }
}
