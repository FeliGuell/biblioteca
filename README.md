# Proyecto Biblioteca Egg

Biblioteca Egg es una aplicación donde se puso a prueba varios conceptos académicos, en donde permite gestionar libros, autores y editoriales de manera eficiente.

![image](https://github.com/user-attachments/assets/6589e3a1-00f5-45e1-a8fc-5fccc90f5e13)


## Tabla de Contenidos

- [Funcionamiento del Login](#funcionamiento-login)
- [Funcionamiento y Roles](#funcionamiento-y-roles)
- [Tecnologías](#tecnologías)
- [Estructura](#estructura)
- [Diagrama entidad-relación](#diagrama-entidad-relacion)
- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Screen](#screen)


## Funcionamiento del Login

- Los usuarios pueden registrarse y acceder al sistema.
- Se ofrece la opción de subir una imagen de perfil para personalizar la cuenta.
- Una vez registrado e iniciado sesión, el usuario puede editar su perfil o cerrar sesión


## Funcionamiento y Roles

- Existen dos roles principales: **ADMIN** y **USER**. Por defecto, los nuevos usuarios se asignan al rol **USER**.
- Para cambiar el rol de un usuario, es necesario realizar una actualización mediante MySQL Workbench u otra herramienta de administración de bases de datos.
- Los usuarios con el rol **USER** tienen acceso solo a la visualización de las listas de libros, autores y editoriales.
- Los usuarios con el rol **ADMIN** pueden modificar y crear libros, autores y editoriales, así como ver y gestionar los usuarios, incluyendo la modificación de sus roles.

## Tecnologías

- **Maven**
- **Spring Data JPA**
- **MySQL**
- **Spring Boot**
- **Spring Web**
- **Spring Security**
- **Thymeleaf**
- **Bootstrap**
- **Docker**
  

## Estructura

``` 
biblioteca/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── biblioteca/
│   │   │           ├── controller/               # Controladores de Spring MVC
│   │   │           ├── entity/                   # Clases de entidad
|   |   |           |── enumerations/             # Clases de enumeraciones
|   |   |           |── exceptions/               # Clases de excepciones
│   │   │           ├── repository/               # Interfaces del repositorio
│   │   │           ├── service/                  # Clases de servicios
│   │   │           ├── BibliotecaApplication.java 
│   │   │           └── SecurityConfig.java        # Configuración de Spring Security
│   │   └── resources/
│   │       ├── static/         # Imagenes y estilos CSS
│   │       ├── templates/      # Templates de Thymeleaf
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── biblioteca/
├── .gitignore
├── README.md
└── pom.xml
```

## Diagrama entidad relacion

![image](https://github.com/user-attachments/assets/47ca735a-4578-4e50-9d17-f2beba096321)


## Requisitos Previos

- JDK 17 o superior
- MySQL 8.0 o superior
- Maven
- Intellij IDEA
- Docker desktop
  
## Instalación

Instrucciones para instalar el proyecto:

1. Clona el repositorio:

  ```bash
   git clone https://github.com/FeliGuell/biblioteca.git
  ```

2. Navega a la carpeta del proyecto:

  ```bash
  cd biblioteca
  ```

3. Compila el proyecto:

  ```bash
  mvn clean package -DskipTests
  ```

## Configuración Docker

1. Configurar docker-compose.yml
2. Construir imagen 
   ```bash
   docker-compose build
   ```
3. Ejecutar aplicación
   ```bash
   docker-compose up
   ```

## Screen

1. Usuario logueado
   ![image](https://github.com/user-attachments/assets/f4f257fa-3512-4580-aa43-323bdeb99774)

2. Listado de libros
   ![image](https://github.com/user-attachments/assets/f6619744-3f75-4176-9074-f60efd35f8b7)

3. Listado de usuarios
   ![image](https://github.com/user-attachments/assets/ca8b1624-2c54-4228-920f-8cc9f529d798)






