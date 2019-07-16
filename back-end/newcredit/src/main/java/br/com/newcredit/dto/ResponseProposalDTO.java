package br.com.newcredit.dto;

import br.com.newcredit.domain.Status;
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
    private Status status;
    private String margin;
    private String descriptionResult;
}
