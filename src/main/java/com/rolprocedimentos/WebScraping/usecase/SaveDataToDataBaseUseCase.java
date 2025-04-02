package com.rolprocedimentos.WebScraping.usecase;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.rolprocedimentos.WebScraping.domain.Operadora;
import com.rolprocedimentos.WebScraping.service.DataProcessingService;
import com.rolprocedimentos.WebScraping.service.DatabaseService;

@Component
public class SaveDataToDataBaseUseCase {

    private final DataProcessingService dataProcessingService;
    private final DatabaseService databaseService;

    public SaveDataToDataBaseUseCase(DataProcessingService dataProcessingService, DatabaseService databaseService) {
        this.dataProcessingService = dataProcessingService;
        this.databaseService = databaseService;
        
    }

    public void saveData(List<String[]> extractedData) {
        List<String[]> processedData = dataProcessingService.replaceAbbreviations(extractedData);
        List<Operadora> operadoras = processedData.stream()
                .map(row -> {
                    Operadora operadora = new Operadora();
                    operadora.setNome(row[0]);
                    operadora.setDespesas(Double.parseDouble(row[1]));
                    return operadora;
                })
                .collect(Collectors.toList());
        
        databaseService.saveOperadoras(operadoras);
    }
}