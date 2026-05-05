package com.weg.DriveFast.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.DriveFast.service.dto.locacao.LocacaoCreateDTO;
import com.weg.DriveFast.service.dto.locacao.LocacaoResponseDTO;
import com.weg.DriveFast.service.dto.mensagem.MensagemDTO;
import com.weg.DriveFast.service.useService.LocacaoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/locacao")
@RequiredArgsConstructor
public class LocacaoController {

    private final LocacaoService service;

    @PostMapping
    public ResponseEntity<LocacaoResponseDTO> realizarLocacao(@Valid @RequestBody LocacaoCreateDTO locacao){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.realizarLocacao(locacao));
    }

    @GetMapping
    public ResponseEntity<List<LocacaoResponseDTO>> listarLocacoes(){
        return ResponseEntity.ok(service.listarLocacoes());
    }

    @GetMapping("/idCliente/{idCliente}")
    public ResponseEntity<List<LocacaoResponseDTO>> buscarLocacaoPorCliente(@PathVariable Long idCliente){
        return ResponseEntity.ok(service.buscarLocacaoPorCliente(idCliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> encerrarLocacao(@PathVariable Long id){
        return ResponseEntity.ok(service.encerrarLocacao(id));
    }
}
