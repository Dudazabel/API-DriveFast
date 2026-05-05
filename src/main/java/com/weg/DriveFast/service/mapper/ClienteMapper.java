package com.weg.DriveFast.service.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.weg.DriveFast.domain.entity.Cliente;
import com.weg.DriveFast.infrastructure.projections.ClienteGastoProjection;
import com.weg.DriveFast.service.dto.cliente.ClienteCreateDTO;
import com.weg.DriveFast.service.dto.cliente.ClienteGastoDTO;
import com.weg.DriveFast.service.dto.cliente.ClienteResponseDTO;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteCreateDTO cliente){
        return new Cliente(
            cliente.nome(),
            cliente.cnh(),
            cliente.email());
    }

    public ClienteResponseDTO toResponseDTO(Cliente cliente){
        return new ClienteResponseDTO(
            cliente.getId(),
            cliente.getNome(),
            cliente.getCnh(),
            cliente.getEmail());
    }

    public List<ClienteResponseDTO> toResponseDTOList(List<Cliente> clientes){
        return clientes
        .stream()
        .map(this::toResponseDTO)
        .toList();
    }

    public ClienteGastoDTO toClienteGastoDTO(ClienteGastoProjection cliente){
        return new ClienteGastoDTO(
            cliente.getNomeCliente(), 
            cliente.getTotalGasto());
    }

    public List<ClienteGastoDTO> toClienteGastoDTOList(List<ClienteGastoProjection> clientes){
        return clientes
            .stream()
            .map(this::toClienteGastoDTO)
            .toList();
    }

}
