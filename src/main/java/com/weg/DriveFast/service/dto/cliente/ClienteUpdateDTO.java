package com.weg.DriveFast.service.dto.cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteUpdateDTO(
    @NotBlank
    String nome,
    
    @NotBlank
    String email
) {

}
