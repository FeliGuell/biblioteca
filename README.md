## Proyecto Biblioteca Egg

Biblioteca Egg es una aplicación que permite gestionar libros, autores y editoriales de manera eficiente.

## Funcionamiento Login

* Los usuarios pueden registrarse y acceder al sistema.
* Se ofrece la opción de subir una imagen de perfil para personalizar la cuenta.
* Una vez registrado e iniciado sesión, el usuario puede editar su perfil o cerrar sesión.


## Funcionamiento y Roles

* Existen dos roles principales: ADMIN y USER. Por defecto, los nuevos usuarios se asignan al rol USER.
* Para cambiar el rol de un usuario, es necesario realizar una actualización mediante MySQL Workbench u otra herramienta de administración de bases de datos.
* Los usuarios con el rol USER tienen acceso solo a la visualización de las listas de libros, autores y editoriales.
* Los usuarios con el rol ADMIN pueden modificar y crear libros, autores y editoriales, así como ver y gestionar los usuarios, incluyendo la modificación de sus roles.


## Tecnologías

* Java
* Spring Data JPA 
* Spring Boot
* Spring Security
* Thymeleaf
* Spring Web
* Bootstrap






