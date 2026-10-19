package br.com.casalsplit.casalsplit_api.domain.model;

public record Usuario(String nome, int idade, boolean estaAtivo) {

    public Usuario {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do usuário é obrigatório.");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
    }
}
