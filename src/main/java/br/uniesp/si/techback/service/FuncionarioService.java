package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Funcionario;
import br.uniesp.si.techback.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor //cria um construtor apenas para as variaveis q estao marcada como final
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public List<Funcionario> listar(){
        return repository.findAll();
    }

    public Funcionario Salvar(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public Funcionario atualizar(Long id, Funcionario funcionario){
        Optional<Funcionario> func = repository.findById(id);
        if(func.isEmpty()){
            throw new RuntimeException("Funcionario inexistente");
        } else {
            return repository.save(funcionario);
        }
    }



    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Id não encontrado");
        }
        repository.deleteById(id);
    }





}

