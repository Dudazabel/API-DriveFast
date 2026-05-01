package com.weg.DriveFast.service.dto.veiculo;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;

public record VeiculoUpdateDTO(
    @NotNull
    BigDecimal valorDiaria
) {

}
