package com.egg.biblioteca.service;

import com.egg.biblioteca.entity.Autor;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public void crearAutor(String nombre) throws MiException {

        validar(nombre);

        Autor autor = new Autor();
        autor.setNombre(nombre);

        autorRepository.save(autor);
    }

    @Transactional(readOnly = true)
    public List<Autor> listarAutores(){
        List<Autor> autores = new ArrayList<>();
        autores = autorRepository.findAll();
        return autores;
    }

    @Transactional(readOnly = true)
    public Autor getOne(String id){
        return autorRepository.findById(id).get();
    }


    @Transactional
    public void modificarAutor(String id, String nombre) throws MiException {

        validar(nombre);

        Optional<Autor> respuesta = autorRepository.findById(id);

        if(respuesta.isPresent()){
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autorRepository.save(autor);
        }
    }

    @Transactional
    public void eliminar(String id) throws MiException{
        Autor autor = autorRepository.getById(id);
        autorRepository.delete(autor);
    }

    private void validar(String id, String nombre) throws MiException {
        if(id.isEmpty() || id == null){
            throw new MiException("El id del Autor no puede estar vacío o ser nulo");
        }
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre del Autor no puede estar vacío o ser nulo");
        }
    }

    private void validar(String nombre) throws MiException{
        if(nombre.isEmpty() || nombre==null){
            throw new MiException("El id del Autor no puede estar vacío o ser nulo");
        }
    }
}
