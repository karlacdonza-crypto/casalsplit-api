package br.com.casalsplit.casalsplit_api.application.port.in;

import br.com.casalsplit.casalsplit_api.domain.model.Despesa;

import java.util.List;

public interface CadastrarDespesaUseCase {

    Despesa cadastrar(NovaDespesaCommand command);

    List<Despesa> listar();
}
