package com.egg.biblioteca.controller;

import com.egg.biblioteca.entity.Usuario;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repository.UsuarioRepository;
import com.egg.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class PortalController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @GetMapping("/registrar")
    public String registrar(){
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password,
                           String password2, ModelMap model, MultipartFile archivo) {
        try{
            usuarioService.registrar(archivo, nombre, email,password,password2);

            model.put("exito", "Usuario registrado correctamente!");

            return "index.html";
        }catch (Exception ex){

            model.put("error", ex.getMessage());
            model.put("nombre", nombre);
            model.put("email", email);

            return "registro.html";
        }
    }


    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap modelo) {
        if(error!=null){
            modelo.put("error", "Usuario o contraseña inválidos!");
        }
        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session) {

        Usuario logueado = (Usuario) session.getAttribute("usuariosession");

        if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        return "inicio.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/perfil")
    public String perfil(ModelMap modelo,HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuariosession");
        modelo.put("usuario", usuario);
        return "usuario_modificar.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping("/perfil/{id}")
    public String actualizar(MultipartFile archivo, @PathVariable("id") String id, @RequestParam String nombre, @RequestParam String email,
                             @RequestParam String password, @RequestParam String password2, ModelMap modelo) {

        try {
            usuarioService.actualizar(archivo, id, nombre, email, password, password2);

            modelo.put("exito", "Usuario actualizado correctamente!");

            return "inicio.html";
        } catch (Exception ex) {

            modelo.put("error", ex.getMessage());
            modelo.put("nombre", nombre);
            modelo.put("email", email);

            return "usuario_modificar.html";
        }

    }


}
