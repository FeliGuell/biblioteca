## Proyecto Biblioteca Egg

Es una biblioteca donde se pueden crear libros, autores y editoriales. 

## Funcionamiento Login

* Se puede registrar un usuario y logearse. 
* Tiene la opción para subir una imagen de usuario. 
* Una vez creado y logueado, cuenta con una función para editar el usuario o cerrar sesión.


## Funcionamiento y Roles

* Existe un rol ADMIN y USER. Una vez que se crea el usuario automáticamente se asigna el rol USER.
* Para cambiar el Rol, se debe cambiar mediante MySQL Workbench u otra herramienta para realizar un UPDATE del rol.
* El rol de tipo USER únicamente puede ver las listas de libros, autores y editoriales.
* El rol de tipo ADMIN puede modificar y crear libros, autores y editoriales. Tiene la opción de ver los usuarios, modificarlos y cambiar el rol.


## Tecnologías

* Java 19
* Spring Data JPA
* Spring Boot
* Spring Security
* Thymeleaf
* Spring Web
* Bootstrap





