package com.weg.DriveFast.service.dto.cliente;

import jakarta.validation.constraints.NotBlank;

public record ClienteCreateDTO(
    @NotBlank
    String nome,

    @NotBlank
    String cnh,

    @NotBlank
    String email
) {

}
