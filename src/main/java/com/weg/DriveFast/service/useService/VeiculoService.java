package com.weg.DriveFast.service.useService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.DriveFast.domain.entity.Veiculo;
import com.weg.DriveFast.infrastructure.repository.VeiculoRepository;
import com.weg.DriveFast.service.dto.mensagem.MensagemDTO;
import com.weg.DriveFast.service.dto.veiculo.VeiculoCreateDTO;
import com.weg.DriveFast.service.dto.veiculo.VeiculoResponseDTO;
import com.weg.DriveFast.service.dto.veiculo.VeiculoUpdateDTO;
import com.weg.DriveFast.service.mapper.VeiculoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoMapper mapper;
    private final VeiculoRepository repository;

    public VeiculoResponseDTO cadastrarVeiculo(VeiculoCreateDTO veiculo){
        Veiculo veiculoSalvo = mapper.toEntity(veiculo);
        return mapper.toResponseDTO(repository.save(veiculoSalvo));
    }

    public List<VeiculoResponseDTO> listarVeiculos(){
        return mapper.toResponseDTOList(repository.findAll());
    }

    public VeiculoResponseDTO buscarVeiculoPorId(Long id){
        return mapper.toResponseDTO(repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Veículo não encontrado")));
    }

    public List<VeiculoResponseDTO> buscarPorDisponibilidade(){
        return mapper.toResponseDTOList(repository.findByDisponivelTrue());
    }

    public VeiculoResponseDTO atualizarVeiculo(Long id, VeiculoUpdateDTO veiculo){
        Veiculo veiculoSalvo = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));
        veiculoSalvo.setValorDiaria(veiculo.valorDiaria());
        return mapper.toResponseDTO(repository.save(veiculoSalvo));
    }

    public MensagemDTO deletarVeiculo(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Veículo não encontrado!");
        }
        repository.deleteById(id);
        return new MensagemDTO("Veículo removido com sucesso!");
    }
}
