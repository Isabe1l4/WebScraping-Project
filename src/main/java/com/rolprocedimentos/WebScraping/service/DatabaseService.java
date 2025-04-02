package com.rolprocedimentos.WebScraping.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.rolprocedimentos.WebScraping.domain.Operadora;
import com.rolprocedimentos.WebScraping.repository.OperadoraRepository;

@Service
public class DatabaseService {

    private final OperadoraRepository operadoraRepository;

    public DatabaseService(OperadoraRepository operadoraRepository) {
        this.operadoraRepository = operadoraRepository;
    }

    public void saveOperadoras(List<Operadora> operadoras) {
        operadoraRepository.saveAll(operadoras);
    }
}