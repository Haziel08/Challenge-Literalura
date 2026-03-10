package com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // Esto ignora todos los campos del JSON que no usemos
public record Datos(
        @JsonAlias("results") List<DatosLibro> resultados
) {
}