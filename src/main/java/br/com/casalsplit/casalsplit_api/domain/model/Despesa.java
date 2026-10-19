package br.com.casalsplit.casalsplit_api.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Despesa(
        UUID id,
        String descricao,
        BigDecimal valor,
        Usuario pagador,
        boolean compartilhada,
        Usuario usuarioDespesaCompartilhada,
        BigDecimal porcentagemPrimeiroUsuario,
        BigDecimal porcentagemSegundoUsuario
) {

    public Despesa {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição da despesa é obrigatória.");
        }
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor da despesa deve ser maior que zero.");
        }
        if (pagador == null) {
            throw new IllegalArgumentException("Pagador da despesa é obrigatório.");
        }
        if (!compartilhada) {
            usuarioDespesaCompartilhada = null;
            porcentagemPrimeiroUsuario = BigDecimal.valueOf(100);
            porcentagemSegundoUsuario = BigDecimal.ZERO;
        } else {
            if (usuarioDespesaCompartilhada == null) {
                throw new IllegalArgumentException("Usuário compartilhado é obrigatório para despesa compartilhada.");
            }
            if (porcentagemPrimeiroUsuario == null || porcentagemSegundoUsuario == null) {
                throw new IllegalArgumentException("Porcentagens de divisão são obrigatórias.");
            }
            BigDecimal soma = porcentagemPrimeiroUsuario.add(porcentagemSegundoUsuario);
            if (soma.compareTo(BigDecimal.valueOf(100)) != 0) {
                throw new IllegalArgumentException("A soma das porcentagens deve ser 100.");
            }
        }
    }
}
