package com.rolprocedimentos.WebScraping.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebScraperService {

    private static final String URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-sociedade/atualizacao-do-rol-de-procedimentos";

    public List<String> getPdfLinks() {
        List<String> pdfLinks = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements links = doc.select("a[href]"); // Busca todos os links na página

            for (Element link : links) {
                String href = link.attr("href");
                if (href.endsWith(".pdf")) {
                    if (!href.startsWith("http")) {
                        href = "https://www.gov.br" + href; // Corrige links relativos
                    }
                    pdfLinks.add(href);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao acessar a página: " + e.getMessage());
        }
        return pdfLinks;
    }
}
