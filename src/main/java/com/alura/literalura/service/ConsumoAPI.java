package com.alura.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public String obtenerDatos(String url) {
        // 1. HttpClient: El cliente que envía la solicitud
        HttpClient client = HttpClient.newHttpClient();

        // 2. HttpRequest: Definimos a dónde ir (la URL de la API)
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // 3. HttpResponse: Recibimos la respuesta como una cadena de texto (String)
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error al conectar con la API de Gutendex: " + e.getMessage());
        }

        return response.body();
    }
}