package br.com.casalsplit.casalsplit_api.adapter.in.web.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record DespesaResponse(
        UUID id,
        String descricao,
        BigDecimal valor,
        UsuarioResponse pagador,
        boolean compartilhada,
        UsuarioResponse usuarioCompartilhado,
        BigDecimal porcentagemPrimeiroUsuario,
        BigDecimal porcentagemSegundoUsuario
) {
}
