package br.com.casalsplit.casalsplit_api.adapter.in.web.dto;

public record UsuarioResponse(
        String nome,
        int idade,
        boolean estaAtivo
) {
}
