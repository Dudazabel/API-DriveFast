package com.weg.DriveFast.service.dto.locacao;

import jakarta.validation.constraints.NotNull;

public record LocacaoCreateDTO(
    @NotNull
    Long clienteId,

    @NotNull
    Long veiculoId,

    @NotNull
    Integer dias
) {

}
