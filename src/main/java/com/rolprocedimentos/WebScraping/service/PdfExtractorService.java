package com.rolprocedimentos.WebScraping.service;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

@Service
public class PdfExtractorService {

    public String extractTextFromPdf(String filePath) {
    	File pdfFile = new File(filePath);
    	System.out.println("Iniciando a extração de texto do PDF...");
    	
    	if (!pdfFile.exists()) {
            System.err.println("Arquivo não encontrado: " + filePath);
            return null;
    	}try (PDDocument document = PDDocument.load(new File(filePath))) {
    		 if (document.isEncrypted()) {
                 System.out.println("O PDF está criptografado e não pode ser lido.");
                 return null;
    		 } 
    		 
    	PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        if (text.isEmpty()) {
                System.out.println("Nenhum texto foi extraído do PDF.");
                
            } else {
                System.out.println("Texto extraído com sucesso.");
                
            }
            return text;
            
        } catch (IOException e) {
        	System.err.println("Erro ao extrair texto do PDF: " + e.getMessage());
            e.printStackTrace();
            
            return null;
        }
    }
}