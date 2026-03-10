package com.alura.literalura.model;
import jakarta.persistence.*;


@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true) // Para no repetir libros
    private String titulo;
    private String idioma;
    private Double numeroDeDescargas;

    @ManyToOne
    private Autor autor;

    public Libro() {}

    // 2. Constructor para convertir desde el Record DatosLibro
    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        // Tomamos solo el primer idioma de la lista como pide el desafío
        this.idioma = datosLibro.idiomas().get(0);
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return """
            ----- LIBRO -----
            Título: %s
            Autor: %s
            Idioma: %s
            Número de descargas: %s
            ------------------
            """.formatted(titulo,
                (autor != null ? autor.getNombre() : "Desconocido"),
                idioma,
                numeroDeDescargas);
    }

}