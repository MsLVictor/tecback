package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Funcionario;
import br.uniesp.si.techback.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //cria um construtor apenas para as variaveis q estao marcada como final
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public Funcionario Salvar(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public List<Funcionario> Listar(){
        return repository.findAll();
    }


}

