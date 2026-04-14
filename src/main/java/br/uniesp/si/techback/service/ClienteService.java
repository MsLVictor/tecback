package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Cliente;
import br.uniesp.si.techback.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new RuntimeException("Cliente inexistente");
        } else {
            return cliente.get();
        }
    }

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente){
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        if(clienteExistente.isEmpty()){
            throw new RuntimeException("Cliente inexistente");
        } else {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
    }

    public void excluir(Long id){
        if(!clienteRepository.existsById(id)){
            throw new RuntimeException("Id não encontrado");
        }
        clienteRepository.deleteById(id);
    }

}
