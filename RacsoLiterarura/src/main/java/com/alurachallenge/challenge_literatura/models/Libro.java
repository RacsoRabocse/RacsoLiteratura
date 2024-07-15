package com.alurachallenge.challenge_literatura.models;

import jakarta.persistence.*;


@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;
//    private String autor;

    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private double numeroDescargas;

    @ManyToOne
    private Autor autor;

    public Libro() {
    }

    public Libro(DatosLibros datosLibros) {
        this.titulo = datosLibros.titulo();
        this.idioma = Idioma.fromString(datosLibros.idiomas().toString().split(",")[0]);
        this.numeroDescargas = datosLibros.numeroDescargas();
    }


    public String getTitulo() {
        return titulo;
    }

    public void setAutor(Autor author) {
        this.autor = author;
    }

    @Override
    public String toString() {
        return "**********Libro**********\n" +
                "titulo: " + titulo + "\n" +
                "idioma: " + idioma + "\n" +
                "autor: " + autor.getNombre() + "\n" +
                "numeroDescargas: " + numeroDescargas + "\n" +
                "*************************";
    }
}
