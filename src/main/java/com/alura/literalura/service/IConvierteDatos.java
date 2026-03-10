package com.alura.literalura.service;

public interface IConvierteDatos {
    // Este metodo genérico <T> permite convertir el JSON a cualquier clase que le pidamos
    <T> T obtenerDatos(String json, Class<T> clase);
}