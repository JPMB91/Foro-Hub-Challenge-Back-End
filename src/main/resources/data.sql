INSERT INTO usuarios (nombre, email, password) 
VALUES ("Joaquin Prieto", "usuario1@forohub.com", "$2a$04$hXahDyMW59eEy3Rb5s0NA.n0c1xD7dJrQieXKegGiCKnc0F0qDyBG")
ON DUPLICATE KEY UPDATE nombre = nombre;

-- Insert topicos (assuming usuario_id = 1 after the user insert)
INSERT INTO topicos (titulo, mensaje, usuario_id, curso) VALUES
("Introducción a Spring Boot", "¿Cuáles son las mejores prácticas para configurar un proyecto Spring Boot desde cero?", 1, "Spring Framework"),
("Manejo de Excepciones en Java", "¿Cómo implementar un manejo global de excepciones en una API REST?", 1, "Java Avanzado"),
("Base de Datos con JPA", "Tengo problemas para configurar las relaciones entre entidades con JPA Hibernate", 1, "Persistencia de Datos"),
("JavaScript Asíncrono", "¿Cuál es la diferencia entre Promises y async/await en JavaScript?", 1, "JavaScript Moderno"),
("Docker para Principiantes", "¿Cómo crear un Dockerfile para una aplicación Spring Boot?", 1, "DevOps"),
("Testing con JUnit", "¿Cuáles son las mejores prácticas para escribir tests unitarios en Spring Boot?", 1, "Testing"),
("Seguridad con JWT", "¿Cómo implementar autenticación JWT en una API REST con Spring Security?", 1, "Seguridad"),
("React Hooks", "¿Cuándo usar useState vs useEffect en componentes funcionales de React?", 1, "Frontend React"),
("Optimización de Consultas SQL", "Mi aplicación es lenta, ¿cómo optimizar las consultas a la base de datos?", 1, "Base de Datos"),
("Microservicios con Spring Cloud", "¿Cómo dividir una aplicación monolítica en microservicios?", 1, "Arquitectura");