package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;//acessar o banco de dados através desse objeto

    //400 algum campo recebido foi enviado errado
    //*método-http* + Mapping
    //para receber o json é preciso uma classe com os mesmos atributos (padrão DTO)

    @PostMapping
    @Transactional//metodo de escrita do spring
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados){
        repository.save(new Medico(dados));
    }

    //a paginação é configurada pelo front end atraves da url
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 3, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosEditarMedico dados){
        //carregar a entidade e depois update nele
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
