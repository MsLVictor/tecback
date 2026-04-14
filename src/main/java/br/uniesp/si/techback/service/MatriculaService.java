package br.uniesp.si.techback.service;


import br.uniesp.si.techback.model.Matricula;
import br.uniesp.si.techback.repository.MatriculaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public List<Matricula> listar(){
        return matriculaRepository.findAll();
    }

    public Matricula buscarPorId(Long id) {
        Optional<Matricula> matricula = matriculaRepository.findById(id);
        if(matricula.isEmpty()){
            throw new RuntimeException("Matricula inexistente");
        } else {
            return matricula.get();
        }
    }

    public Matricula salvar(Matricula matricula){
        return matriculaRepository.save(matricula);
    }

    public Matricula atualizar(Long id, Matricula matricula){
        Optional<Matricula> matriculaExistente = matriculaRepository.findById(id);
        if(matriculaExistente.isEmpty()){
            throw new RuntimeException("Matricula inexistente");
        } else {
            matricula.setId(id);
            return matriculaRepository.save(matricula);
        }
    }

    public void excluir(Long id){
        if(!matriculaRepository.existsById(id)){
            throw new RuntimeException("Id não encontrado");
        }
        matriculaRepository.deleteById(id);
    }

}

