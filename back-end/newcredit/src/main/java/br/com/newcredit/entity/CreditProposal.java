package br.com.newcredit.entity;

import br.com.newcredit.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditProposal {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName="id",nullable=false)
    private Customer customer;
    private Status status;
    private String margin;
    private String descriptionResult;
}
