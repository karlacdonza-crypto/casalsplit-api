package br.com.casalsplit.casalsplit_api.adapter.in.web;

import br.com.casalsplit.casalsplit_api.adapter.in.web.dto.DespesaResponse;
import br.com.casalsplit.casalsplit_api.adapter.in.web.dto.NovaDespesaRequest;
import br.com.casalsplit.casalsplit_api.adapter.in.web.dto.UsuarioRequest;
import br.com.casalsplit.casalsplit_api.adapter.in.web.dto.UsuarioResponse;
import br.com.casalsplit.casalsplit_api.application.port.in.CadastrarDespesaUseCase;
import br.com.casalsplit.casalsplit_api.application.port.in.NovaDespesaCommand;
import br.com.casalsplit.casalsplit_api.domain.model.Despesa;
import br.com.casalsplit.casalsplit_api.domain.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/despesas")
public class DespesaController {

    private final CadastrarDespesaUseCase cadastrarDespesaUseCase;

    public DespesaController(CadastrarDespesaUseCase cadastrarDespesaUseCase) {
        this.cadastrarDespesaUseCase = cadastrarDespesaUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DespesaResponse criar(@Valid @RequestBody NovaDespesaRequest request) {
        NovaDespesaCommand command = new NovaDespesaCommand(
                request.descricao(),
                request.valor(),
                request.pagador().nome(),
                request.pagador().idade(),
                request.pagador().estaAtivo(),
                request.compartilhada(),
                request.usuarioCompartilhado() != null ? request.usuarioCompartilhado().nome() : null,
                request.usuarioCompartilhado() != null ? request.usuarioCompartilhado().idade() : null,
                request.usuarioCompartilhado() != null ? request.usuarioCompartilhado().estaAtivo() : null,
                request.porcentagemPrimeiroUsuario(),
                request.porcentagemSegundoUsuario()
        );

        Despesa despesa = cadastrarDespesaUseCase.cadastrar(command);
        return toResponse(despesa);
    }

    @GetMapping
    public List<DespesaResponse> listar() {
        return cadastrarDespesaUseCase.listar().stream().map(this::toResponse).toList();
    }

    private DespesaResponse toResponse(Despesa despesa) {
        return new DespesaResponse(
                despesa.id(),
                despesa.descricao(),
                despesa.valor(),
                toUsuarioResponse(despesa.pagador()),
                despesa.compartilhada(),
                toUsuarioResponse(despesa.usuarioDespesaCompartilhada()),
                despesa.porcentagemPrimeiroUsuario(),
                despesa.porcentagemSegundoUsuario()
        );
    }

    private UsuarioResponse toUsuarioResponse(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        return new UsuarioResponse(usuario.nome(), usuario.idade(), usuario.estaAtivo());
    }
}
