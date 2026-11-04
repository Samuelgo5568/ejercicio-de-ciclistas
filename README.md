# Ejercicio de ciclistas 

El programa crea un equipo, le agrega ciclistas de diferentes especialidades y
muestra los datos del equipo y permite buscar un ciclista por su identificador.

## Clases

- **Ciclista**: clase abstracta con identificador, nombre y tiempo acumulado.
- **Velocista**: tiene potencia promedio y velocidad de sprint.
- **Escalador**: tiene aceleración en subida y grado de rampa.
- **Contrarrelojista**: tiene velocidad máxima.
- **Equipo**: guarda los ciclistas, calcula el total de tiempos y busca por
  identificador.
- **Main**: clase de prueba con el método `main`.

## Cómo ejecutarlo

Se necesita Java 17 y Maven.

```bash
mvn test
mvn exec:java
```

También se puede crear el JAR:

```bash
mvn package
java -jar target/carrera-ciclistica-1.0.0.jar
```

Al ejecutar el programa pide un identificador. Los del ejemplo son:

- 101: Ana Lucía Gómez (velocista)
- 102: Carlos Pérez (escalador)
- 103: Marta Ruiz (contrarrelojista)

## Pruebas unitarias

Hay **5 pruebas** en `CarreraTest.java`:

1. El ciclista empieza con tiempo cero.
2. Cada especialidad devuelve su tipo.
3. El equipo guarda sus ciclistas.
4. El equipo calcula bien el total de tiempos.
5. La búsqueda por identificador funciona.

Resultado:

```text
Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
```

## Documentación

La explicación más completa está en [DOCUMENTACION.md](DOCUMENTACION.md).

## Commits

1. Estructura inicial y clase `Ciclista`.
2. Especialidades y clase `Equipo`.
3. Pruebas unitarias y documentación.
