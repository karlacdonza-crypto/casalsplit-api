package br.com.casalsplit.casalsplit_api.application.port.out;

import br.com.casalsplit.casalsplit_api.domain.model.Despesa;

import java.util.List;

public interface DespesaRepositoryPort {

    Despesa salvar(Despesa despesa);

    List<Despesa> listar();
}
