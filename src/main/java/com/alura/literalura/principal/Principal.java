package com.alura.literalura.principal;

import com.alura.literalura.model.Autor;
import com.alura.literalura.model.Datos;
import com.alura.literalura.model.DatosLibro;
import com.alura.literalura.model.Libro;
import com.alura.literalura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.service.ConsumoAPI;
import com.alura.literalura.service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner lectura = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/";

    // Repositorios para interactuar con la DB
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;

    // El constructor ahora recibe los repositorios desde la aplicación principal
    public Principal(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    ***************************************************
                    1 - Buscar libro por título
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                    0 - Salir
                    ***************************************************
                    """;
            System.out.println(menu);
            try {
                opcion = lectura.nextInt();
                lectura.nextLine();

                switch (opcion) {
                    case 1 -> buscarLibroWeb();
                    case 2 -> listarLibrosRegistrados();
                    case 3 -> listarAutoresRegistrados();
                    case 4 -> listarAutoresVivos();
                    case 5 -> listarLibrosPorIdioma();
                    case 0 -> System.out.println("Cerrando la aplicación...");
                    default -> System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingresa un número válido.");
                lectura.nextLine();
            }
        }
    }

    private DatosLibro getDatosLibro() {
        System.out.println("Escribe el nombre del libro que deseas buscar:");
        var nombreLibro = lectura.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "+"));
        Datos datosBusqueda = conversor.obtenerDatos(json, Datos.class);

        // Retornamos el primer resultado si existe
        return datosBusqueda.resultados().stream()
                .findFirst()
                .orElse(null);
    }

    private void buscarLibroWeb() {
        DatosLibro datos = getDatosLibro();

        if (datos != null) {
            // Verificamos si el libro ya está en la base de datos
            Optional<Libro> libroExistente = libroRepository.findByTituloContainsIgnoreCase(datos.titulo());
            if (libroExistente.isPresent()) {
                System.out.println("El libro ya se encuentra registrado.");
                return;
            }

            // Manejo del Autor (evitar duplicados en la tabla autores)
            Autor autor = null;
            if (!datos.autor().isEmpty()) {
                var datosAutor = datos.autor().get(0);
                Optional<Autor> autorDb = autorRepository.findByNombreContainsIgnoreCase(datosAutor.nombre());

                if (autorDb.isPresent()) {
                    autor = autorDb.get();
                } else {
                    autor = new Autor(datosAutor);
                    autorRepository.save(autor);
                }
            }

            // Creamos y guardamos el libro
            Libro libro = new Libro(datos);
            libro.setAutor(autor);
            libroRepository.save(libro);
            System.out.println("--- LIBRO REGISTRADO ---");
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    private void listarAutoresVivos() {
        System.out.println("Ingrese el año para buscar autores vivos:");
        var anio = lectura.nextInt();
        lectura.nextLine();
        List<Autor> autores = autorRepository.buscarAutoresVivosEnAnio(anio);
        autores.forEach(System.out::println);
    }

    private void listarLibrosPorIdioma() {
        System.out.println("""
                Ingrese el idioma para buscar los libros:
                es - español
                en - inglés
                fr - francés
                pt - portugués
                """);
        var idioma = lectura.nextLine();
        List<Libro> libros = libroRepository.findByIdioma(idioma);
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en ese idioma.");
        } else {
            libros.forEach(System.out::println);
        }
    }
}