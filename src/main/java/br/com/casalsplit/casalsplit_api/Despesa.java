package br.com.casalsplit.casalsplit_api;

import java.math.BigDecimal;

public class Despesa {
    String despesa;
    BigDecimal valor;
    Usuario usuario;
    boolean compartilhada;
    Usuario usuarioDespesaCompartilhada;
    float porcentagemPrimeiroUsuario;
    float porcentagemSegundoUsuario;
}
