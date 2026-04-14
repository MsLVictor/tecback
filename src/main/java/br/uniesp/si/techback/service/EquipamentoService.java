package br.uniesp.si.techback.service;


import br.uniesp.si.techback.model.Equipamento;
import br.uniesp.si.techback.repository.EquipamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipamentoService {

    private final EquipamentoRepository equipamentoRepository;

    public List<Equipamento> listar(){
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarPorId(Long id) {
        Optional<Equipamento> equipamento = equipamentoRepository.findById(id);
        if(equipamento.isEmpty()){
            throw new RuntimeException("Equipamento inexistente");
        } else {
            return equipamento.get();
        }
    }

    public Equipamento salvar(Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento atualizar(Long id, Equipamento equipamento){
        Optional<Equipamento> equipamentoExistente = equipamentoRepository.findById(id);
        if(equipamentoExistente.isEmpty()){
            throw new RuntimeException("Equipamento inexistente");
        } else {
            equipamento.setId(id);
            return equipamentoRepository.save(equipamento);
        }
    }

    public void excluir(Long id){
        if(!equipamentoRepository.existsById(id)){
            throw new RuntimeException("Id não encontrado");
        }
        equipamentoRepository.deleteById(id);
    }

}

