package com.rolprocedimentos.WebScraping.service;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataProcessingService {
    public List<String[]> replaceAbbreviations(List<String[]> data) {
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                if (row[i].equals("OD")) {
                    row[i] = "Descrição Completa de OD";
                }
                if (row[i].equals("AMB")) {
                    row[i] = "Descrição Completa de AMB";
                }
            }
        }
        return data;
    }
}