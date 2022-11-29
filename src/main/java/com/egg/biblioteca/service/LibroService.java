package com.egg.biblioteca.service;


import com.egg.biblioteca.entity.Autor;
import com.egg.biblioteca.entity.Editorial;
import com.egg.biblioteca.entity.Libro;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repository.AutorRepository;
import com.egg.biblioteca.repository.EditorialRepository;
import com.egg.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditorialRepository editorialRepository;

    @Transactional
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException {

        validar(isbn,titulo,ejemplares,idAutor,idEditorial);

        Optional<Autor> respuestaAutor = autorRepository.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepository.findById(idEditorial);

        Autor autor = new Autor();
        Editorial editorial= new Editorial();

        if(respuestaAutor.isPresent()){

            autor = respuestaAutor.get();
        }

        if(respuestaEditorial.isPresent()){

            editorial = respuestaEditorial.get();
        }

        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepository.save(libro);
    }

    @Transactional(readOnly = true)
    public List<Libro> listarLibros(){
        List<Libro> libros = new ArrayList<>();
        libros = libroRepository.findAll();
        return libros;
    }

    @Transactional
    public void modificarLibro(Long isbn, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException {

        validar(isbn,titulo,ejemplares,idAutor,idEditorial);

        Optional<Libro> respuesta = libroRepository.findById(isbn);
        Optional<Autor> respuestaAutor = autorRepository.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepository.findById(idEditorial);

        Autor autor = new Autor();
        Editorial editorial = new Editorial();

        if(respuestaAutor.isPresent()){
            autor = respuestaAutor.get();
        }

        if(respuestaEditorial.isPresent()){
            editorial = respuestaEditorial.get();
        }

        if(respuesta.isPresent()){
            Libro libro = respuesta.get();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);

            libroRepository.save(libro);
        }
    }

    @Transactional(readOnly = true)
    public Libro getOne(Long id){
        return libroRepository.getOne(id);
    }


    private void validar(Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial) throws MiException{
        if(isbn == null){
            throw new MiException("El isbn no puede ser nulo");
        }
        if(titulo.isEmpty() || titulo == null){
            throw new MiException("El título no puede ser nulo o estar vacío");
        }
        if(ejemplares == null){
            throw new MiException("Los ejemplares no puede estar vacío");
        }
        if(idAutor.isEmpty() || idAutor == null){
            throw new MiException("El autor no puede ser nulo o estar vacío");
        }
        if(idEditorial.isEmpty() || idEditorial == null){
            throw new MiException("El Editorial no puede ser nula o estar vacía");
        }
    }

}
