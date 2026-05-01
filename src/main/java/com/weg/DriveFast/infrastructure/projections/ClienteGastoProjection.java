package com.weg.DriveFast.infrastructure.projections;

import java.math.BigDecimal;

public interface ClienteGastoProjection {

    String getNomeCliente();
    BigDecimal getTotalGasto();
}
