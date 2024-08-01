package br.edu.ifsp.pw3.api.Controller;

import br.edu.ifsp.pw3.api.Concerto.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("concertos")
public class ConcertoController {

    @Autowired
    private ConcertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroConcerto dados,
                                                        UriComponentsBuilder uriBuilder) {
        var concerto = new Concerto(dados);
        repository.save(concerto);
        var uri = uriBuilder.path("/concertos/{id}").buildAndExpand(concerto.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoConcerto(concerto));
    }

    @GetMapping
    public Page<Concerto> listar(
        @PageableDefault(size=3,
        page=0,
        sort={"dataentrada", "mecanico.nome"},
        direction = Sort.Direction.ASC ) Pageable paginacao) {

        return repository.findAllByAtivoTrue(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity getConcertoById(@PathVariable Long id) {

        Optional<Concerto> concertoOptinal = repository.findById(id);

        if (concertoOptinal.isPresent()) {
            Concerto concerto = concertoOptinal.get();
            return ResponseEntity.ok(new DadosDetalhamentoConcerto(concerto));
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    @RequestMapping("algunsdados")
    public List<DadosListagemConcerto> listarAlgunsDados() {
        return repository.findAll().stream().map(DadosListagemConcerto::new).toList();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConcerto dados) {
        Concerto concerto = repository.getReferenceById(dados.id());
        concerto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConcerto(concerto));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Concerto concerto = repository.getReferenceById(id);
        concerto.excluir();
        return ResponseEntity.noContent().build();
    }
}