package br.com.newcredit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProposalDTO {
    private String cpf;
    private String status;
    private String margin;
    private String descriptionResult;
}
