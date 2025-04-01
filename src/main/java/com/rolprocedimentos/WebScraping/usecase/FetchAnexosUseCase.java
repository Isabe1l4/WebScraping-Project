package com.rolprocedimentos.WebScraping.usecase;

import com.rolprocedimentos.WebScraping.service.WebScraperService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FetchAnexosUseCase {

    private final WebScraperService webScraperService;

    public FetchAnexosUseCase(WebScraperService webScraperService) {
        this.webScraperService = webScraperService;
    }

    public List<String> execute() {
        List<String> allLinks = webScraperService.getPdfLinks();

        System.out.println("Todos os links antes do filtro: " + allLinks);

        // Filtrar apenas os anexos desejados (Anexo I e II)
        List<String> anexos = allLinks.stream()
                .filter(link -> link.toLowerCase().contains("anexo_i") || link.toLowerCase().contains("anexo_ii"))
                .collect(Collectors.toList());

        System.out.println("Links dos anexos filtrados: " + anexos);

        return anexos;
    }

}
