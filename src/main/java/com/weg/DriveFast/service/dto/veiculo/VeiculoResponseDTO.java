package com.weg.DriveFast.service.dto.veiculo;

import java.math.BigDecimal;

public record VeiculoResponseDTO(
    Long id,
    String marca,
    String modelo,
    String placa,
    BigDecimal valorDiaria,
    boolean disponivel
) {

}
