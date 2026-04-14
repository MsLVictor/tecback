package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Equipamento;
import br.uniesp.si.techback.service.EquipamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;

    @GetMapping
    public List<Equipamento> listar(){
        return equipamentoService.listar();
    }

    @GetMapping("/{id}")
    public Equipamento buscarPorId(@PathVariable Long id){
        return equipamentoService.buscarPorId(id);
    }

    @PostMapping
    public Equipamento salvar(@RequestBody Equipamento equipamento){
        return equipamentoService.salvar(equipamento);
    }

    @PutMapping("/{id}")
    public Equipamento atualizar(@PathVariable Long id,
                                 @RequestBody Equipamento equipamento){
        return equipamentoService.atualizar(id, equipamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Equipamento> excluir(@PathVariable Long id){
        equipamentoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

}

