# Alura Oracle One Challenge: Foro-hub

## Este proyecto consiste en una API creada usando Spring boot

## Tech Stack:💻

- Java 17
- Spring Boot / Spring web Security
- JPA
- MySQL
- Flyway
- Java JWT


## Requisitos para correr la aplicación

- [Postman]((https://www.postman.com/downloads/)) o [Insomnia](https://insomnia.rest/download) para acceder a las rutas
- [Intellij](https://www.jetbrains.com/idea/download/) para levantar el servidor



## ⚠️Atención
Todas las rutas están protegidas excepto la de login por lo que requiere hacer inicio de sesion en: 
http://localhost:8080/login y obtener un token para acceder al resto de las rutas.


Datos de acceso:

```
{

    "email": "usuario1@forohub.com",

    "password": "123456"

}
```

## Features 🚀

### Esta aplicación permite:

1. Logear un usuario
2. Crear un tópico
3. Obtener una lista de tópicos registrados en la base de datos.
4. Obtener un tópico especifico accediendo por su Id
5. Actualizar un tópico por su Id
6. Eliminar un tópico por su Id.