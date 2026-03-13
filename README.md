# AUTO_API_PETSTORE_SCREENPLAY: Automatización CRUD Petstore

## 📋 Índice
1. [Descripción del Proyecto](#-descripción-del-proyecto)
2. [Propuesta de Valor](#-propuesta-de-valor)
3. [Ciclo CRUD Automatizado (User)](#-ciclo-crud-automatizado-user)
4. [Tecnologías y Stack](#-tecnologías-y-stack)
5. [Arquitectura y Patrones (Screenplay Rest)](#-arquitectura-y-patrones-screenplay-rest)
6. [Estructura del Proyecto](#-estructura-del-proyecto)
7. [Requisitos Previos](#-requisitos-previos)
8. [Manual de Ejecución](#-manual-de-ejecución)
9. [Reportes de API](#-reportes-de-api)

---

## 🚀 Descripción del Proyecto
Este repositorio contiene la automatización de pruebas para la capa de servicios de la **Petstore Swagger**. El objetivo es validar la integridad de las operaciones del recurso **User** utilizando el patrón **Screenplay** y las capacidades de **Serenity Rest**.

> "La automatización de API asegura que la lógica de negocio y la persistencia de datos sean correctas antes de llegar a la interfaz de usuario, garantizando contratos de servicio estables."

## 💎 Propuesta de Valor
*   **Validación de Contratos:** Asegura que los endpoints respondan con las estructuras JSON y códigos de estado correctos.
*   **Ciclo de Vida Completo:** Garantiza que un recurso pueda ser creado, consultado, modificado y eliminado sin errores de integridad.
*   **Eficiencia:** Pruebas de ejecución rápida que detectan fallos en la lógica del backend de forma temprana.

## 🔄 Ciclo CRUD Automatizado (User)
Siguiendo los requerimientos del reto, se ha implementado un **único flujo de prueba** que valida los 4 verbos principales sobre el recurso `/user`:

1.  **POST (Create):** Creación de un nuevo usuario en el sistema.
2.  **GET (Read):** Consulta del usuario mediante su `username` para validar la creación.
3.  **PUT (Update):** Actualización de la información del usuario (ej. cambio de correo o teléfono).
4.  **DELETE (Delete):** Eliminación del usuario y verificación de que ya no existe en el sistema.

## 🛠️ Tecnologías y Stack
*   **Lenguaje:** Java 17+.
*   **Framework de Automatización:** Serenity BDD.
*   **Librería de API:** Serenity Rest.
*   **Patrón de Diseño:** Screenplay.
*   **Test Runner:** Cucumber (JUnit).
*   **Gestión de Dependencias:** Gradle.

## 🏗️ Arquitectura y Patrones (Screenplay Rest)
A diferencia de la automatización Front-End, aquí el Actor utiliza la capacidad **`CallAnApi`** [Instrucciones experto]:

*   **Actor:** El protagonista que realiza las peticiones a los servicios REST.
*   **Tasks:** Tareas de negocio que orquestan el envío de datos (ej. `CrearUsuario`, `ActualizarDatos`).
*   **Interactions:** Uso de los métodos HTTP nativos de Serenity Rest: `Post`, `Get`, `Put`, `Delete`.
*   **Questions:** Verificaciones del código de estado (200, 201, 404) y del contenido del JSON de respuesta.
*   **Models/Data:** Clases POJO para la serialización y deserialización de los objetos de usuario.

## 📂 Estructura del Proyecto
```text
src/test
└── java
    └── com.sofkianos
        ├── models          <-- Objetos Java (POJOs) para los JSON
        ├── questions       <-- Validaciones de códigos de estado y esquemas
        ├── runners         <-- Ejecutor de Cucumber
        ├── stepdefinitions <-- Mapeo de Gherkin al Actor de API
        └── tasks            <-- Tareas del ciclo CRUD (Responsabilidad única)
└── resources
    ├── features            <-- Escenario CRUD declarativo
    └── serenity.conf       <-- Configuración de la URL base y logs
```

## 📋 Requisitos Previos
*   **Java JDK 17** o superior.
*   **Gradle**.
*   **Git**.
*   Conexión a internet (para acceder a `https://petstore.swagger.io/v2`).

## ⚙️ Manual de Ejecución
1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/tu-usuario/AUTO_API_PETSTORE_SCREENPLAY.git
    ```
2.  **Ejecutar las pruebas:**
    El comando ejecutará el ciclo CRUD completo y generará el reporte agregado de Serenity:
    ```bash
    gradle clean test aggregate
    ```

## 📊 Reportes de API
Serenity BDD ofrece un detalle exhaustivo de las pruebas de API, incluyendo [Instrucciones experto]:
*   **Request:** URL, Headers y Body enviado.
*   **Response:** Código de estado y JSON de respuesta.
*   **Ubicación:** `target/site/serenity/index.html`.

---
**Nota:** Este proyecto forma parte del **Taller Semana 5: Maestría en Automatización**.