package com.rolprocedimentos.WebScraping.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataProcessingService {

    // Método para substituir as abreviações "OD" e "AMB"
    public List<String[]> replaceAbbreviations(List<String[]> data) {
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                if (row[i].equals("OD")) {
                    row[i] = "Descrição Completa de OD";  // Substitua pela descrição correta
                }
                if (row[i].equals("AMB")) {
                    row[i] = "Descrição Completa de AMB";  // Substitua pela descrição correta
                }
            }
        }
        return data;
    }
}