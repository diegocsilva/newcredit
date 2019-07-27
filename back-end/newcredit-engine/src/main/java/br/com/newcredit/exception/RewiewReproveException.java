package br.com.newcredit.exception;

import br.com.newcredit.dto.ResponseProposalDTO;

public class RewiewReproveException extends RuntimeException{

    private ResponseProposalDTO response;

    public RewiewReproveException(ResponseProposalDTO response) {
        super();
        this.response = response;
    }

    public ResponseProposalDTO getResponse() {
        return response;
    }
}
