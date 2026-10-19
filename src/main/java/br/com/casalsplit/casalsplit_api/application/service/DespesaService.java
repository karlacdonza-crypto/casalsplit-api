package br.com.casalsplit.casalsplit_api.application.service;

import br.com.casalsplit.casalsplit_api.application.port.in.CadastrarDespesaUseCase;
import br.com.casalsplit.casalsplit_api.application.port.in.NovaDespesaCommand;
import br.com.casalsplit.casalsplit_api.application.port.out.DespesaRepositoryPort;
import br.com.casalsplit.casalsplit_api.domain.model.Despesa;
import br.com.casalsplit.casalsplit_api.domain.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DespesaService implements CadastrarDespesaUseCase {

    private final DespesaRepositoryPort despesaRepositoryPort;

    public DespesaService(DespesaRepositoryPort despesaRepositoryPort) {
        this.despesaRepositoryPort = despesaRepositoryPort;
    }

    @Override
    public Despesa cadastrar(NovaDespesaCommand command) {
        Usuario pagador = new Usuario(command.nomePagador(), command.idadePagador(), command.pagadorAtivo());

        Usuario usuarioCompartilhado = null;
        if (command.compartilhada()) {
            if (command.idadeUsuarioCompartilhado() == null || command.usuarioCompartilhadoAtivo() == null) {
                throw new IllegalArgumentException("Dados do usuário compartilhado estão incompletos.");
            }
            usuarioCompartilhado = new Usuario(
                    command.nomeUsuarioCompartilhado(),
                    command.idadeUsuarioCompartilhado(),
                    command.usuarioCompartilhadoAtivo()
            );
        }

        Despesa despesa = new Despesa(
                UUID.randomUUID(),
                command.descricao(),
                command.valor(),
                pagador,
                command.compartilhada(),
                usuarioCompartilhado,
                command.porcentagemPrimeiroUsuario(),
                command.porcentagemSegundoUsuario()
        );

        return despesaRepositoryPort.salvar(despesa);
    }

    @Override
    public List<Despesa> listar() {
        return despesaRepositoryPort.listar();
    }
}
