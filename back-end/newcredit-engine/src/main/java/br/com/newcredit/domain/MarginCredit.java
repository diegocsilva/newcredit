package br.com.newcredit.domain;

import lombok.Getter;

@Getter
public enum MarginCredit {
    RENDA_BAIXA("renda baixa"),
    REPROVADO_PELA_POLITICA_DE_CREDITO("reprovado pela política de crédito"),
    ENTRE_100_A_500("entre 100 - 500"),
    ENTRE_500_A_1000("entre 500 - 1000"),
    ENTRE_1000_A_1500("entre 1000 - 1500"),
    ENTRE_1500_A_2000("entre 1500 - 2000"),
    SUPERIOR_A_2000("superior 2000");

    private String description;

    MarginCredit(String description) {
        this.description = description;
    }
}

