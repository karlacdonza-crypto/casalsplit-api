package br.com.casalsplit.casalsplit_api.application.port.in;

import java.math.BigDecimal;

public record NovaDespesaCommand(
        String descricao,
        BigDecimal valor,
        String nomePagador,
        int idadePagador,
        boolean pagadorAtivo,
        boolean compartilhada,
        String nomeUsuarioCompartilhado,
        Integer idadeUsuarioCompartilhado,
        Boolean usuarioCompartilhadoAtivo,
        BigDecimal porcentagemPrimeiroUsuario,
        BigDecimal porcentagemSegundoUsuario
) {
}
