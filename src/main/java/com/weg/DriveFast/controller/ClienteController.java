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

import com.weg.DriveFast.service.dto.cliente.ClienteCreateDTO;
import com.weg.DriveFast.service.dto.cliente.ClienteGastoDTO;
import com.weg.DriveFast.service.dto.cliente.ClienteResponseDTO;
import com.weg.DriveFast.service.dto.cliente.ClienteUpdateDTO;
import com.weg.DriveFast.service.dto.mensagem.MensagemDTO;
import com.weg.DriveFast.service.useService.ClienteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@Valid @RequestBody ClienteCreateDTO cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarCliente(cliente));
    }

    @GetMapping("/todosClientes")
    public ResponseEntity<List<ClienteResponseDTO>> listarCliente(){
        return ResponseEntity.ok(service.listarClientes());
    }

    @GetMapping("/idCliente/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarClientePorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarClientePorId(id));
    }

    @GetMapping("/relatorioGastos")
    public ResponseEntity<List<ClienteGastoDTO>> buscarRelatorioGastoCliente(){
        return ResponseEntity.ok(service.buscarRelatorioGastosCliente());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@Valid @PathVariable Long id, @RequestBody ClienteUpdateDTO cliente){
        return ResponseEntity.ok(service.atualizarCliente(cliente, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemDTO> deletarCliente(@PathVariable Long id){
        return ResponseEntity.ok(service.deletarCliente(id));
    }
}
