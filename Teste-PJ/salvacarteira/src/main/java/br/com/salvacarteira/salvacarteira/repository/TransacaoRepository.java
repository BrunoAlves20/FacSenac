package br.com.salvacarteira.salvacarteira.repository;

import br.com.salvacarteira.salvacarteira.model.TipoTransacao;
import br.com.salvacarteira.salvacarteira.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    // Consultas personalizadas para o Dashboard
    // Se não houver nada, retorna null, então usamos COALESCE para garantir que retorne 0
    
    @Query("SELECT COALESCE(SUM(t.valor), 0) FROM Transacao t WHERE t.tipo = :tipo")
    BigDecimal calcularTotalPorTipo(@Param("tipo") TipoTransacao tipo);
}