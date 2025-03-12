package com.evento.enums;

public enum Perfil {
    ADMINISTRADOR ("administrador"),
    FUNCIONARIO ("funcionario"),
    GERENTE ("gerente");

    public String descricao;

    Perfil(String descricao) {
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }
}
