package com.rolprocedimentos.WebScraping.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rolprocedimentos.WebScraping.usecase.DownloadAnexosUseCase;

@RestController
@RequestMapping("/files")
public class FileDownloadController {

    private final DownloadAnexosUseCase downloadAnexosUseCase;

    public FileDownloadController(DownloadAnexosUseCase downloadAnexosUseCase) {
        this.downloadAnexosUseCase = downloadAnexosUseCase;
    }

    @GetMapping("/download-anexos")
    public List<String> downloadAnexos() {
        return downloadAnexosUseCase.execute();
    }
}
