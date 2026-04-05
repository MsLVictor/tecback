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

    private final FuncionarioRepository FuncionarioRepository;


    public List<Funcionario> listar(){
        return FuncionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        Optional<Funcionario> func = FuncionarioRepository.findById(id);
        if(func.isEmpty()){
            throw new RuntimeException("Funcionario inexistente");
        } else {
            return func.get();
        }
    }

    public Funcionario Salvar(Funcionario funcionario){
        return FuncionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(Long id, Funcionario funcionario){
        Optional<Funcionario> func = FuncionarioRepository.findById(id);
        if(func.isEmpty()){
            throw new RuntimeException("Funcionario inexistente");
        } else {
            return FuncionarioRepository.save(funcionario);
        }
    }



    public void excluir(Long id){
        if(!FuncionarioRepository.existsById(id)){
            throw new RuntimeException("Id não encontrado");
        }
        FuncionarioRepository.deleteById(id);
    }



}

