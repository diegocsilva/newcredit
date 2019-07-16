package br.com.newcredit.dto;

import br.com.newcredit.domain.MaritalStatus;
import br.com.newcredit.domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProposalDTO {

    private String name;
    private String cpf;
    private Integer age;
    private Sex sex;
    private MaritalStatus maritalStatus;
    private String state;
    private Integer dependents;
    private Double income;
}
