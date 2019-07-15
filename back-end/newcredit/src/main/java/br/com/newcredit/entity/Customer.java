package br.com.newcredit.entity;

import br.com.newcredit.domain.MaritalStatus;
import br.com.newcredit.domain.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String cpf;
    private Integer age;
    private Sex sex;
    private MaritalStatus maritalStatus;
    private String state;
    private Integer dependents;
    private Double income;
}
