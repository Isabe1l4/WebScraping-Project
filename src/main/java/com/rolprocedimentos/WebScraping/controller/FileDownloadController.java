package com.rolprocedimentos.WebScraping.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rolprocedimentos.WebScraping.usecase.DownloadAnexosUseCase;
import com.rolprocedimentos.WebScraping.usecase.ProcessDataUseCase;

@RestController
@RequestMapping("/files")
public class FileDownloadController {

    private final DownloadAnexosUseCase downloadAnexosUseCase;
    private final ProcessDataUseCase processDataUseCase;

    public FileDownloadController(DownloadAnexosUseCase downloadAnexosUseCase, ProcessDataUseCase processDataUseCase) {
        this.downloadAnexosUseCase = downloadAnexosUseCase;
        this.processDataUseCase = processDataUseCase;
    }

    @GetMapping("/download-anexos")
    public List<String> downloadAnexos() {
        return downloadAnexosUseCase.execute();
    }

    @GetMapping("/process-and-save-data")
    public String processAndSaveData() {
        List<String[]> extractedData = extractDataFromPdf();
        String csvFilePath = "output.csv";

        processDataUseCase.processAndSaveData(extractedData, csvFilePath);

        return "Dados processados e salvos com sucesso!";
    }

    private List<String[]> extractDataFromPdf() {
        return List.of(
                new String[]{"Coluna1", "Coluna2", "Coluna3"},
                new String[]{"Valor1", "Valor2", "Valor3"}
        );
    }
}