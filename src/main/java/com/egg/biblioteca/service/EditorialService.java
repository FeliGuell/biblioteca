package com.egg.biblioteca.service;

import com.egg.biblioteca.entity.Editorial;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;

    @Transactional
    public void crearEditorial(String nombre) throws MiException {

        validar(nombre);

        Editorial editorial = new Editorial();
        editorial.setNombre(nombre);
        editorialRepository.save(editorial);
    }

    @Transactional(readOnly = true)
    public List<Editorial> listarEditorial(){
        List<Editorial> editoriales = new ArrayList<>();
        editoriales = editorialRepository.findAll();
        return editoriales;
    }

    @Transactional(readOnly = true)
    public Editorial getOne(String id){
        return editorialRepository.getOne(id);
    }

    @Transactional
    public void modificarEditorial(String id, String nombre) throws MiException {

        validar(id,nombre);

        Optional<Editorial> respuesta = editorialRepository.findById(id);

        if(respuesta.isPresent()){
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
            editorialRepository.save(editorial);
        }
    }

    private void validar(String id, String nombre) throws MiException{
        if(id.isEmpty() || id == null){
            throw new MiException("El id de la Editorial no puede estar vacía o ser nula");
        }
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre de la Editorial no puede estar vacío o ser nulo");
        }
    }

    private void validar(String nombre) throws MiException{
        if(nombre.isEmpty() || nombre == null){
            throw new MiException("El nombre de la Editorial no puede estar vacío o ser nulo");
        }
    }


}
