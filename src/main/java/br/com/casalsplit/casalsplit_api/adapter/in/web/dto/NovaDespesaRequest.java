package br.com.casalsplit.casalsplit_api.adapter.in.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record NovaDespesaRequest(
        @NotBlank(message = "descricao é obrigatória")
        String descricao,
        @NotNull(message = "valor é obrigatório")
        @DecimalMin(value = "0.01", message = "valor deve ser maior que zero")
        BigDecimal valor,
        @Valid
        @NotNull(message = "pagador é obrigatório")
        UsuarioRequest pagador,
        boolean compartilhada,
        @Valid
        UsuarioRequest usuarioCompartilhado,
        @DecimalMin(value = "0.0", message = "porcentagemPrimeiroUsuario deve ser maior ou igual a 0")
        @DecimalMax(value = "100.0", message = "porcentagemPrimeiroUsuario deve ser menor ou igual a 100")
        BigDecimal porcentagemPrimeiroUsuario,
        @DecimalMin(value = "0.0", message = "porcentagemSegundoUsuario deve ser maior ou igual a 0")
        @DecimalMax(value = "100.0", message = "porcentagemSegundoUsuario deve ser menor ou igual a 100")
        BigDecimal porcentagemSegundoUsuario
) {
}
