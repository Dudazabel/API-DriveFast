package com.weg.DriveFast.service.useService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.DriveFast.domain.entity.Cliente;
import com.weg.DriveFast.infrastructure.projections.ClienteGastoProjection;
import com.weg.DriveFast.infrastructure.repository.ClienteRepository;
import com.weg.DriveFast.service.dto.cliente.ClienteCreateDTO;
import com.weg.DriveFast.service.dto.cliente.ClienteGastoDTO;
import com.weg.DriveFast.service.dto.cliente.ClienteResponseDTO;
import com.weg.DriveFast.service.dto.cliente.ClienteUpdateDTO;
import com.weg.DriveFast.service.dto.mensagem.MensagemDTO;
import com.weg.DriveFast.service.mapper.ClienteMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteResponseDTO cadastrarCliente(ClienteCreateDTO cliente){
        Cliente clienteSalvo = mapper.toEntity(cliente);
        return mapper.toResponseDTO(repository.save(clienteSalvo));
    }

    public List<ClienteResponseDTO> listarClientes(){
        return mapper.toResponseDTOList(repository.findAll());
    }

    public ClienteResponseDTO buscarClientePorId(Long id){
        return mapper.toResponseDTO(repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado!")));
    }

    public List<ClienteGastoDTO> buscarRelatorioGastosCliente(){
        List<ClienteGastoProjection> cliente = repository.relatorioGastos();
        return mapper.toClienteGastoDTOList(cliente);
    }

    public ClienteResponseDTO atualizarCliente(ClienteUpdateDTO cliente, Long clienteId){
        Cliente clienteSalvo = repository.findById(clienteId)
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
        clienteSalvo.setNome(cliente.nome());
        clienteSalvo.setEmail(cliente.email());
        return mapper.toResponseDTO(repository.save(clienteSalvo));
    }

    public MensagemDTO deletarCliente(Long clienteId){
        if(!repository.existsById(clienteId)){
            throw new RuntimeException("Cliente não encontrado!");
        }
        repository.deleteById(clienteId);
        return new MensagemDTO("Cliente removido com sucesso!");
    }

}
