package br.com.casalsplit.casalsplit_api.adapter.out.memory;

import br.com.casalsplit.casalsplit_api.application.port.out.DespesaRepositoryPort;
import br.com.casalsplit.casalsplit_api.domain.model.Despesa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class InMemoryDespesaRepositoryAdapter implements DespesaRepositoryPort {

    private final List<Despesa> despesas = new CopyOnWriteArrayList<>();

    @Override
    public Despesa salvar(Despesa despesa) {
        despesas.add(despesa);
        return despesa;
    }

    @Override
    public List<Despesa> listar() {
        return new ArrayList<>(despesas);
    }
}
