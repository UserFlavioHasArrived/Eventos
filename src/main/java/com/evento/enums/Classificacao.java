package com.evento.enums;

public enum Classificacao {
    LIVRE("livre"),
    ACIMA_12_ANOS("acima de 12 anos"),
    ACIMA_18_ANOS("acima de 18 anos");

    private String descricao;

    Classificacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        this.descricao = "rrrr";
        return descricao;
    }
}
