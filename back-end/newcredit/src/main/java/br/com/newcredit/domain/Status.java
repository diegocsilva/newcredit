package br.com.newcredit.domain;

import lombok.Getter;

@Getter
public enum Status {
    APPROVED("Aprovado"),
    DENIED("Negado");

    private String name;

    Status(String name) {
        this.name = name;
    }
}
