package com.rolprocedimentos.WebScraping.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rolprocedimentos.WebScraping.service.CsvService;
import com.rolprocedimentos.WebScraping.service.DataProcessingService;

@Component
public class ProcessDataUseCase {

    private final DataProcessingService dataProcessingService;
    private final CsvService csvService;

    public ProcessDataUseCase(DataProcessingService dataProcessingService, CsvService csvService) {
        this.dataProcessingService = dataProcessingService;
        this.csvService = csvService;
    }

    public void processAndSaveData(List<String[]> extractedData, String csvFilePath) {
        // Substituir abreviações antes de salvar
        List<String[]> processedData = dataProcessingService.replaceAbbreviations(extractedData);

        // Salvar no arquivo CSV
        csvService.writeCsv(csvFilePath, processedData);
    }
}