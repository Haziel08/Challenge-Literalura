package com.alura.literalura.repository;

import com.alura.literalura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    /// Para la validación de libros existentes
    Optional<Libro> findByTituloContainsIgnoreCase(String titulo);

    // Para la opción 5 del menú
    List<Libro> findByIdioma(String idioma);
}