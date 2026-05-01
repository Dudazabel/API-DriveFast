package com.weg.DriveFast.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weg.DriveFast.domain.entity.Cliente;
import com.weg.DriveFast.infrastructure.projections.ClienteGastoProjection;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    @Query(value = """
            SELECT c.nome AS nomeCliente,
            SUM(l.valor_total) AS totalGasto
            FROM locacao l 
            JOIN cliente c ON l.cliente_id = c.id
            GROUP BY c.nome
            """, nativeQuery = true)
    List<ClienteGastoProjection> relatorioGastos();
}
