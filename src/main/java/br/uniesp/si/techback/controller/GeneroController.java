package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Genero;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    private static List<Genero> Lista = new ArrayList<>();

    @GetMapping
    public List<Genero> Listar(){
        return Lista;
    }

    @PostMapping
    public Genero Criar(Genero genero){
        Lista.add(genero);
        return genero;
    }

    @PutMapping
    public String Atualizar(){
        return "Atualizando";
    }

    @DeleteMapping
    public String Deletar(){
        return "Deletando";
    }
}
