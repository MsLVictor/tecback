package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Plano;
import br.uniesp.si.techback.repository.PlanoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanoService {

    private final PlanoRepository planoRepository;

    public List<Plano> listar(){
        return planoRepository.findAll();
    }

    public Plano buscarPorId(Long id) {
        Optional<Plano> plano = planoRepository.findById(id);
        if(plano.isEmpty()){
            throw new RuntimeException("Plano inexistente");
        } else {
            return plano.get();
        }
    }

    public Plano salvar(Plano plano){
        return planoRepository.save(plano);
    }

    public Plano atualizar(Long id, Plano plano){
        Optional<Plano> planoExistente = planoRepository.findById(id);
        if(planoExistente.isEmpty()){
            throw new RuntimeException("Plano inexistente");
        } else {
            plano.setId(id);
            return planoRepository.save(plano);
        }
    }

    public void excluir(Long id){
        if(!planoRepository.existsById(id)){
            throw new RuntimeException("Id não encontrado");
        }
        planoRepository.deleteById(id);
    }

}
