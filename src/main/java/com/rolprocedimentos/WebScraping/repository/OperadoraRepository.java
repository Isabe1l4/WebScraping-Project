package com.rolprocedimentos.WebScraping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rolprocedimentos.WebScraping.domain.Operadora;

@Repository
public interface OperadoraRepository extends JpaRepository<Operadora, Long> {

}