package com.weg.DriveFast.service.useService;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.DriveFast.domain.entity.Cliente;
import com.weg.DriveFast.domain.entity.Locacao;
import com.weg.DriveFast.domain.entity.Veiculo;
import com.weg.DriveFast.infrastructure.repository.ClienteRepository;
import com.weg.DriveFast.infrastructure.repository.LocacaoRepository;
import com.weg.DriveFast.infrastructure.repository.VeiculoRepository;
import com.weg.DriveFast.service.dto.locacao.LocacaoCreateDTO;
import com.weg.DriveFast.service.dto.locacao.LocacaoResponseDTO;
import com.weg.DriveFast.service.mapper.LocacaoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoService {

    private final LocacaoRepository repository;
    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;
    private final LocacaoMapper mapper;

    public LocacaoResponseDTO realizarLocacao(LocacaoCreateDTO locacao){
        
        Cliente cliente = clienteRepository.findById(locacao.clienteId())
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));

        Veiculo veiculo = veiculoRepository.findById(locacao.veiculoId())
        .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));

        if(!veiculo.isDisponivel()){
            throw new RuntimeException("Veículo está indisponível!");
        }

        BigDecimal valorTotal = veiculo.getValorDiaria().multiply(BigDecimal.valueOf(locacao.dias()));

        Locacao locacaoSalva = new Locacao();

        locacaoSalva.setCliente(cliente);
        locacaoSalva.setVeiculo(veiculo);
        locacaoSalva.setDias(locacao.dias());
        locacaoSalva.setValorTotal(valorTotal);

        veiculo.setDisponivel(false);

        veiculoRepository.save(veiculo);
        return mapper.toResponseDTO(repository.save(locacaoSalva));
    }

    public List<LocacaoResponseDTO> listarLocacoes(){
        return mapper.toResponseDTOList(repository.findAll());
    }
}
