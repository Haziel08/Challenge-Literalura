# Challenge LiterAlura - Catálogo de Libros - Haziel Ibares

<p align="center">
  <img width="2000" height="600" alt="BannerLiteralura" src="https://github.com/user-attachments/assets/ba8c2b1a-f946-4553-8906-86099408d91f" />
</p>

<p align="center">
  <img src="https://img.shields.io/badge/status-TERMINADO-brightgreen?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Última%20modificación-marzo%202026-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring--Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white" />
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" />
  <img src="https://img.shields.io/badge/reto%20de-Alura-ff6f61?style=for-the-badge" />
</p>

---
## Índice

- [Descripción del proyecto](#descripción-del-proyecto)
- [Capturas de Pantalla](#capturas-de-pantalla)
- [Características y Funcionalidades](#características-y-funcionalidades)
- [Tecnologías utilizadas](#tecnologías-utilizadas)
- [Autor](#autor)

---

## Descripción del proyecto

**LiterAlura** es un sistema de gestión de catálogos de libros desarrollado en Java utilizando el framework **Spring Boot**. El proyecto consume datos en tiempo real de la API pública **Gutendex** para buscar libros por título, procesar la información mediante la biblioteca **Jackson** y almacenarla de forma persistente en una base de datos **PostgreSQL**.

El sistema ofrece una interfaz de consola interactiva, permitiendo realizar consultas avanzadas sobre autores y filtrar libros por idioma de manera eficiente.

---

## Capturas de Pantalla

Aquí puedes observar el funcionamiento de la aplicación en la terminal:

### 1. Menú Principal y Búsqueda de Libros
Muestra de la interfaz de usuario y el resultado de una búsqueda exitosa vinculada a la API.
<img width="450" height="278" alt="CapturaLiteralura1" src="https://github.com/user-attachments/assets/a7faf5f7-918c-49d6-963c-84d8f3b2c600" />
<img width="391" height="150" alt="CapturaLiteralura2" src="https://github.com/user-attachments/assets/33ef042e-321f-4a35-bf28-aa04f8f86959" />


### 2. Base de Datos PostgreSQL (pgAdmin)
Vista de las tablas de libros y autores generadas automáticamente y pobladas con datos reales.
<img width="624" height="495" alt="CapturaLiteralura3" src="https://github.com/user-attachments/assets/e5ade6d2-df42-4768-8550-b9f74c4dd387" />
<img width="1002" height="502" alt="CapturaLiteralura4" src="https://github.com/user-attachments/assets/06b08cf8-dee1-47bc-b043-bb5246e6f545" />


### 3. Consultas de Autores e Idiomas
Ejemplo de cómo el sistema filtra autores vivos en un año determinado y cuenta libros por idioma.
<img width="472" height="260" alt="CapturaLitealura5" src="https://github.com/user-attachments/assets/4f49f35d-4ad5-42a2-8e81-5ff8c1e516c5" />
<img width="373" height="116" alt="CapturaLiteralura6" src="https://github.com/user-attachments/assets/bdbbb99c-42d9-4503-b499-5a6ec3afbbbf" />


---

## Características y Funcionalidades

- **Consulta a API Externa:** Conexión mediante `HttpClient` para obtener datos de libros y autores desde Gutendex.
- **Persistencia con JPA:** Almacenamiento automático y gestión de relaciones entre libros y autores en PostgreSQL.
- **Búsqueda Inteligente:** Filtros para localizar autores vivos en años específicos y libros por código de idioma.
- **Validación de Duplicados:** Lógica integrada para evitar registros repetidos de autores y libros en la base de datos.
- **Interfaz Amigable:** Presentación de resultados en consola mediante formatos limpios y fichas detalladas.

---

## Tecnologías utilizadas

- **Java JDK 17+**
- **Spring Boot 4.0.3**
- **Spring Data JPA**
- **PostgreSQL**
- **Biblioteca Jackson 2.16.0:** Para el análisis de datos JSON.
- **Maven:** Para la gestión de dependencias.

---

## Autor

| [<img src="https://avatars.githubusercontent.com/u/75911106?v=4" width=115><br><sub>Haziel Ibares Sánchez</sub>](https://github.com/Haziel08) |
| :---: |
---

*Proyecto desarrollado como parte del programa de formación de Alura Latam.*
