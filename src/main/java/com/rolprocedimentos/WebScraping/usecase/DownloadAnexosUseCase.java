package com.rolprocedimentos.WebScraping.usecase;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import com.rolprocedimentos.WebScraping.service.FileDownloadService;

@Component
public class DownloadAnexosUseCase {

    private final FetchAnexosUseCase fetchAnexosUseCase;
    private final FileDownloadService fileDownloadService;

    public DownloadAnexosUseCase(FetchAnexosUseCase fetchAnexosUseCase, FileDownloadService fileDownloadService) {
        this.fetchAnexosUseCase = fetchAnexosUseCase;
        this.fileDownloadService = fileDownloadService;
    }

    public List<String> execute() {
        List<String> anexos = fetchAnexosUseCase.execute();
      
        return anexos.stream()
                .map(fileDownloadService::downloadFile)
                .collect(Collectors.toList());
    }
   
    
	}
