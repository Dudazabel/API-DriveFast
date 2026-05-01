package com.weg.DriveFast.service.mapper;

import org.springframework.stereotype.Component;

import com.weg.DriveFast.domain.entity.Locacao;
import com.weg.DriveFast.service.dto.locacao.LocacaoResponseDTO;

@Component
public class LocacaoMapper {

    public LocacaoResponseDTO toResponseDTO(Locacao locacao){
        return new LocacaoResponseDTO(
            locacao.getId(), 
            locacao.getDias(), 
            locacao.getValorTotal(), 
            locacao.getCliente().getNome(), 
            locacao.getVeiculo().getModelo());
    }

}
