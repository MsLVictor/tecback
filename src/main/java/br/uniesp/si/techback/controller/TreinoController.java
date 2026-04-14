package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Treino;
import br.uniesp.si.techback.service.TreinoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/treinos")
public class TreinoController {

    private final TreinoService treinoService;

    @GetMapping
    public List<Treino> listar(){
        return treinoService.listar();
    }

    @GetMapping("/{id}")
    public Treino buscarPorId(@PathVariable Long id){
        return treinoService.buscarPorId(id);
    }

    @PostMapping
    public Treino salvar(@RequestBody Treino treino){
        return treinoService.salvar(treino);
    }

    @PutMapping("/{id}")
    public Treino atualizar(@PathVariable Long id,
                            @RequestBody Treino treino){
        return treinoService.atualizar(id, treino);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Treino> excluir(@PathVariable Long id){
        treinoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
