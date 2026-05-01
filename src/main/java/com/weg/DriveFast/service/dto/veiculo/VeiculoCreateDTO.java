package com.weg.DriveFast.service.dto.veiculo;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoCreateDTO(
    @NotBlank
    String marca,

    @NotBlank
    String modelo,

    @NotBlank
    String placa,

    @NotNull
    BigDecimal valorDiaria
) {

}
