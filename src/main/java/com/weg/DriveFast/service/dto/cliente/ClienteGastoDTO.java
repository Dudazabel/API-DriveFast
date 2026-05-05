package com.weg.DriveFast.service.dto.cliente;

import java.math.BigDecimal;

public record ClienteGastoDTO(
    String nome,
    BigDecimal totalGasto
) {

}
