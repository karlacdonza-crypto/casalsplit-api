package br.com.casalsplit.casalsplit_api.adapter.in.web.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequest(
        @NotBlank(message = "nome é obrigatório")
        String nome,
        @Min(value = 0, message = "idade deve ser maior ou igual a 0")
        int idade,
        boolean estaAtivo
) {
}
