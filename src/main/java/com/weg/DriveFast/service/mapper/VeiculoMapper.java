package com.weg.DriveFast.service.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.weg.DriveFast.domain.entity.Veiculo;
import com.weg.DriveFast.service.dto.veiculo.VeiculoCreateDTO;
import com.weg.DriveFast.service.dto.veiculo.VeiculoResponseDTO;

@Component
public class VeiculoMapper {

    public Veiculo toEntity(VeiculoCreateDTO veiculo){
        return new Veiculo(
            veiculo.marca(), 
            veiculo.modelo(), 
            veiculo.placa(), 
            veiculo.valorDiaria());
    }

    public VeiculoResponseDTO toResponseDTO(Veiculo veiculo){
        return new VeiculoResponseDTO(
            veiculo.getId(), 
            veiculo.getMarca(), 
            veiculo.getModelo(),
            veiculo.getPlaca(),
            veiculo.getValorDiaria(),
            veiculo.isDisponivel());
    }

    public List<VeiculoResponseDTO> toResponseDTOList(List<Veiculo> veiculos){
        return veiculos
        .stream()
        .map(this::toResponseDTO)
        .toList();
    }
}

