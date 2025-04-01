package com.rolprocedimentos.WebScraping.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileDownloadService {

    private static final String DOWNLOAD_DIR = "downloads/";

    public FileDownloadService() {
        // Criar diretório se não existir
        File directory = new File(DOWNLOAD_DIR);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public String downloadFile(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException("Erro ao baixar arquivo: " + fileUrl);
            }

            String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
            Path filePath = Path.of(DOWNLOAD_DIR, fileName);

            try (InputStream inputStream = connection.getInputStream()) {
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            }

            return filePath.toString();

        } catch (IOException e) {
            System.err.println("Erro ao baixar o arquivo: " + fileUrl + " - " + e.getMessage());
            return null;
        }
    }
}