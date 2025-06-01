# Proyecto CRUD de Personas con Servlets y JSP

Este proyecto es una implementación simple de un CRUD (Create, Read, Update, Delete) de personas utilizando **Java con Servlets**, **JSP** y **Tomcat 9**, sin frameworks externos ni JavaScript.

## 📁 Estructura del Proyecto

```
src/
├── java/
│   └── com/
│       └── scerutti/
│           ├── conexion/         # Clase Conexion a MySQL (opcional)
│           ├── controladores/    # Servlets
│           ├── modelos/          # Modelo Persona.java
│           ├── repositorio/      # Interfaces e implementaciones de repositorio
│           └── shared/           # Logger centralizado
└── webapp/
    ├── WEB-INF/
    │   └── vistas/               # Vistas JSP
    └── index.jsp
```

## 🧠 Funcionalidades

- Mostrar lista de personas (mockeadas o desde BD)
- Agregar persona vía formulario
- Confirmación de carga
- Página de error
- Configuración de logger con `java.util.logging`

## ⚙️ Tecnologías

- Java 8+
- Servlets (`javax.servlet`)
- JSP
- Tomcat 9
- MySQL
- Logger con `java.util.logging`

## 🚀 Cómo ejecutar

1. Clonar este repositorio
2. Abrir el proyecto en un IDE (IntelliJ, Eclipse, VSCode)
3. Asegurar que esté configurado con un Tomcat 9 y JDK 8+
4. Ejecutar en el servidor y acceder a `http://localhost:8080/`

## 🛠 Configuración de base de datos para este proyecto

```sql
CREATE DATABASE personas_tomcat_conection;

CREATE TABLE persona (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  apellido VARCHAR(100),
  dni VARCHAR(15),
  fechaNacimiento VARCHAR(20),
  edad INT,
  email VARCHAR(100)
);
```

Configurar los datos de acceso a la base en [config.properties](src/main/resources/config.properties) (¡no subir credenciales reales!)

## ✅ Mejores prácticas aplicadas

- Separación en capas: Modelo, Repositorio, Controlador, Vista
- Uso de `Logger` centralizado
- Código limpio sin uso de `System.out.println`
- Manejo de excepciones
- Uso de interfaces (`PersonaRepositorio`)
- Implementación mockeada (`PersonaRepositorioMock`) y otra con BD (`PersonaRepositorioBD`)

## 📌 Notas

Este proyecto fue creado con fines educativos para practicar Java Web clásico. No utiliza frameworks modernos como Spring.

---

**Autor:** [Seba Cerutti](https://www.linkedin.com/in/cerutti-sebastiáng/)
