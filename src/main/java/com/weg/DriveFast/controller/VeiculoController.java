package com.weg.DriveFast.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.DriveFast.service.dto.mensagem.MensagemDTO;
import com.weg.DriveFast.service.dto.veiculo.VeiculoCreateDTO;
import com.weg.DriveFast.service.dto.veiculo.VeiculoResponseDTO;
import com.weg.DriveFast.service.dto.veiculo.VeiculoUpdateDTO;
import com.weg.DriveFast.service.useService.VeiculoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/veiculo")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> cadastrarVeiculo(@Valid @RequestBody VeiculoCreateDTO veiculo){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarVeiculo(veiculo));
    }

    @GetMapping("/todosVeiculos")
    public ResponseEntity<List<VeiculoResponseDTO>> listarVeiculos(){
        return ResponseEntity.ok(service.listarVeiculos());
    }

    @GetMapping("/idVeiculo/{id}")
    public ResponseEntity<VeiculoResponseDTO> buscarVeiculoPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarVeiculoPorId(id));
    }

    @GetMapping("/disponivel")
    public ResponseEntity<List<VeiculoResponseDTO>> buscarPorDisponibilidade(){
        return ResponseEntity.ok(service.buscarPorDisponibilidade());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> atualizarVeiculo(@Valid @PathVariable Long id, @RequestBody VeiculoUpdateDTO veiculo){
        return ResponseEntity.ok(service.atualizarVeiculo(id, veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> deletarVeiculo(@PathVariable Long id){
        return ResponseEntity.ok(service.deletarVeiculo(id));
    }
}
