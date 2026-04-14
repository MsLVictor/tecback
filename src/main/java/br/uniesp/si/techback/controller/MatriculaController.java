package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Matricula;
import br.uniesp.si.techback.service.MatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @GetMapping
    public List<Matricula> listar(){
        return matriculaService.listar();
    }

    @GetMapping("/{id}")
    public Matricula buscarPorId(@PathVariable Long id){
        return matriculaService.buscarPorId(id);
    }

    @PostMapping
    public Matricula salvar(@RequestBody Matricula matricula){
        return matriculaService.salvar(matricula);
    }

    @PutMapping("/{id}")
    public Matricula atualizar(@PathVariable Long id,
                               @RequestBody Matricula matricula){
        return matriculaService.atualizar(id, matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Matricula> excluir(@PathVariable Long id){
        matriculaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
