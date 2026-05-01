package com.weg.DriveFast.service.dto.cliente;

public record ClienteResponseDTO(
    Long id,
    String nome,
    String cnh,
    String email
) {

}
