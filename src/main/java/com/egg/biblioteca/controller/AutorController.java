package com.egg.biblioteca.controller;

import com.egg.biblioteca.entity.Autor;
import com.egg.biblioteca.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/registrar") //localhost:8080/autor/registrar
    public String registrar(){
        return "autor_form.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo){

        try {
            autorService.crearAutor(nombre);

            modelo.put("exito", "El Autor fue registrado correctamente!");
        } catch (Exception ex) {
            modelo.put("error", ex.getMessage());
            return "autor_form.html";
        }

        return "index.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/lista")
    public String listar(ModelMap modelo){

        List <Autor> autores = autorService.listarAutores();

        modelo.addAttribute("autores", autores);

        return "autor_list.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") String id, ModelMap modelo){

        modelo.put("autor", autorService.getOne(id));

        return "autor_modificar.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") String id, String nombre, ModelMap modelo){
        try {
            autorService.modificarAutor(id, nombre);

            return "redirect:../lista";
        } catch (Exception ex){
            modelo.put("error", ex.getMessage());
            return "autor_modificar.html";
        }

    }





}
