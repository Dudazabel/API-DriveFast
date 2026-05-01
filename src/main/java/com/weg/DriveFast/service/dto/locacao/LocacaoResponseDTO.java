package com.weg.DriveFast.service.dto.locacao;

import java.math.BigDecimal;

public record LocacaoResponseDTO(
    Long id,
    Integer dias,
    BigDecimal valorTotal,
    String nomeCliente,
    String modeloVeiculo
) {

}
