# ArquitecturaSpringBoot

## Ejercicio propuesto arquitectura Spring Boot


El objetivo será desarrollar una pequeña API REST con el material que hemos visto durante la tutoría, que permita gestionar libros usando Spring Boot 3 y Spring Data JPA, aplicando buenas prácticas (DTOs, validaciones, servicios, consultas personalizadas) y sin olvidar los conocimientos impartidos el Lunes (principios SOLID).

### Requisitos funcionales:

Crear un proyecto que permita:
1. Crear un libro
   * EndPoint: POST /apit/libros
2. Listar todos los libros
    * Endpoint: GET /apit/libros
3. Buscar libros por autor (contenga texto)
    * Endpoint: GET /api/libros/buscar?autor=martin
4. Listar libros con más de X páginas
    * EndPoint: GET /api/libros/mayores?paginas=300

### Atributos Libro:
1. id (Long, autogenerado)
2. titulo (String, obligatorio)
3. autor (String, obligatorio)
4. paginas (int, mínimo 1)

### Reglas del ejercicio:
* La entidad Libro debe estar en entity.
* Usar @RestController, @Service, @Repository.
* Crear un DTO para la entrada / salida con validaciones.
* Convertir entre entidad y DTO manualmente (cómo vimos en clase)
* Guardar libros en memoria usando H2.
* Incluir al menos dos consultras personalizadas:
  * Una con nombre derivado
  * Otra con @Query
  
### Pistas
* Se recomiendan las anotaciones @SpringBootApplication, @PostMapping, @GetMapping, @Valid, @RequestParam, etc...
* Usa CommandLineRunner opcionalmente para insertar datos iniciales.
* Puedes usar lombok para añadir anotaciones cómo @Data, @AllArgsConstructor, @Getter, @Setter, etc...
* Usa application.properties para configurar H2 (ya lo hemos hecho en clase)
* El puerto de la aplicación tiene que ser el 8090
## Ejercicios Extras (Opcionales)
Para aquellos que consigan terminar el ejercicio propuesto y solo entonces después de terminarlo. Modificaremos el siguiente endpoint:

GET /api/libros lo modificaremos por GET /api/libros?page=0&size=5

### Pistas
No hace falta que hagas nada "loco", recordemos que Spring Data ya lo permite por defecto.

Echarle un vistazo al objeto Pageable.