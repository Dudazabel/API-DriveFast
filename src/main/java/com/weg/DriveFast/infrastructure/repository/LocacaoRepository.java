package com.weg.DriveFast.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.weg.DriveFast.domain.entity.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>{

    @Query("""
            SELECT l
            FROM Locacao l
            WHERE l.cliente_id = :clienteId
            """)
    List<Locacao> buscarLocacoesPorClientes(@Param("clienteId") Long clienteId);
    
}
