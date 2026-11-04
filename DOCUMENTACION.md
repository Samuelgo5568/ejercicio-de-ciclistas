# Documentación del ejercicio

## 1. ¿Qué hace el programa?

El programa maneja un equipo de ciclistas. Cada ciclista tiene un
identificador, un nombre y un tiempo acumulado en minutos. Hay tres tipos de
ciclistas: velocista, escalador y contrarrelojista. El equipo guarda a sus
ciclistas y calcula la suma de sus tiempos.

Al final, el programa pide un identificador por teclado y muestra los datos del
ciclista. Si no existe, muestra un mensaje.

## 2. Clases

| Clase | Descripción |
|---|---|
| `Ciclista` | Clase abstracta con los datos comunes. |
| `Velocista` | Ciclista con potencia promedio y velocidad de sprint. |
| `Escalador` | Ciclista con aceleración en subida y grado de rampa. |
| `Contrarrelojista` | Ciclista con velocidad máxima. |
| `Equipo` | Guarda la lista de ciclistas y hace los cálculos. |
| `Main` | Crea el equipo de ejemplo y atiende la búsqueda. |

### Atributos principales

`Ciclista` tiene:

- `identificador` (`int`)
- `nombre` (`String`)
- `tiempoAcumulado` (`double`), que empieza en cero.

`Equipo` tiene:

- `nombre` (`String`)
- `pais` (`String`)
- `sumaTiempos` (`double`, estático)
- `ciclistas` (`List<Ciclista>`)

## 3. Herencia

`Velocista`, `Escalador` y `Contrarrelojista` heredan de `Ciclista`. En sus
constructores llaman a `super(identificador, nombre)`.

Cada especialidad sobrescribe `imprimir()` y `imprimirTipo()`:

- `imprimir()` llama primero a `super.imprimir()` y después muestra sus propios
  datos.
- `imprimirTipo()` devuelve un texto como `"Es un Velocista"`.

## 4. Métodos importantes

En `Ciclista`:

- get y set de cada atributo.
- `imprimir()`: muestra los datos comunes.
- `imprimirTipo()`: es abstracto, por eso cada clase hija lo implementa.

En `Equipo`:

- `anadirCiclista(Ciclista)`: agrega un ciclista.
- `calcularTotalTiempos()`: suma los tiempos.
- `listarNombres()`: devuelve los nombres de los ciclistas.
- `buscarCiclista(int)`: busca por identificador y devuelve un `Optional`.
- `imprimir()`: muestra los datos del equipo.

Los métodos de `Equipo` y los get/set de las especialidades son `protected`,
como pide el ejercicio. Por eso `Main` y las pruebas están en el mismo paquete.

## 5. Pruebas unitarias

Las pruebas están en `src/test/java/com/carrera/ciclismo/CarreraTest.java`.
Son 5:

| # | Prueba | Qué revisa |
|---|---|---|
| 1 | `ciclistaIniciaConTiempoCero` | Identificador, nombre y tiempo inicial. |
| 2 | `cadaEspecialidadDevuelveSuTipo` | El texto de `imprimirTipo()`. |
| 3 | `equipoGuardaSusCiclistas` | Que el equipo guarde los ciclistas. |
| 4 | `equipoCalculaElTotalDeTiempos` | La suma de los tiempos. |
| 5 | `buscarCiclistaPorIdentificador` | Búsqueda encontrada y no encontrada. |

Para ejecutarlas:

```bash
mvn test
```

## 6. Cómo ejecutar el programa

```bash
mvn exec:java
```

O también:

```bash
mvn package
java -jar target/carrera-ciclistica-1.0.0.jar
```

## 7. Notas

- `sumaTiempos` es estático porque así lo pide el enunciado. Por eso el ejemplo
  trabaja con un solo equipo.
- Se agregaron validaciones sencillas: no se permiten identificadores menores
  o iguales a cero, nombres vacíos, tiempos negativos ni ciclistas repetidos.
- Si en Windows se ven mal los acentos, se puede ejecutar `chcp 65001` antes de
  iniciar el programa.
