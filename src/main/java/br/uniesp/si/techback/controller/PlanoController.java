package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Plano;
import br.uniesp.si.techback.service.PlanoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/planos")
public class PlanoController {

    private final PlanoService planoService;

    @GetMapping
    public List<Plano> listar(){
        return planoService.listar();
    }

    @GetMapping("/{id}")
    public Plano buscarPorId(@PathVariable Long id){
        return planoService.buscarPorId(id);
    }

    @PostMapping
    public Plano salvar(@RequestBody Plano plano){
        return planoService.salvar(plano);
    }

    @PutMapping("/{id}")
    public Plano atualizar(@PathVariable Long id,
                           @RequestBody Plano plano){
        return planoService.atualizar(id, plano);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Plano> excluir(@PathVariable Long id){
        planoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
