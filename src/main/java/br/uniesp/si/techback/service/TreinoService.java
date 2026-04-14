package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Treino;
import br.uniesp.si.techback.repository.TreinoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final TreinoRepository treinoRepository;

    public List<Treino> listar(){
        return treinoRepository.findAll();
    }

    public Treino buscarPorId(Long id) {
        Optional<Treino> treino = treinoRepository.findById(id);
        if(treino.isEmpty()){
            throw new RuntimeException("Treino inexistente");
        } else {
            return treino.get();
        }
    }

    public Treino salvar(Treino treino){
        return treinoRepository.save(treino);
    }

    public Treino atualizar(Long id, Treino treino){
        Optional<Treino> treinoExistente = treinoRepository.findById(id);
        if(treinoExistente.isEmpty()){
            throw new RuntimeException("Treino inexistente");
        } else {
            treino.setId(id);
            return treinoRepository.save(treino);
        }
    }

    public void excluir(Long id){
        if(!treinoRepository.existsById(id)){
            throw new RuntimeException("Id não encontrado");
        }
        treinoRepository.deleteById(id);
    }

}
