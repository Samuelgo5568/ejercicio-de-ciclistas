package com.carrera.ciclismo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Representa a un equipo de ciclistas que participa en una carrera.
 *
 * <p>Un equipo se identifica por su nombre y su país, y está conformado por un
 * conjunto de ciclistas. La suma de los tiempos de carrera de sus ciclistas se
 * almacena en el atributo estático {@code sumaTiempos}, tal como exige el
 * enunciado.</p>
 *
 * <p>Los métodos de esta clase son protegidos para que solo puedan utilizarse
 * desde el mismo paquete o desde una subclase. La clase de prueba
 * {@code Main} se encuentra en el mismo paquete para poder utilizarlos.</p>
 *
 * @version 1.0
 */
public class Equipo {

    /** Nombre del equipo. */
    private String nombre;

    /**
     * Suma de los tiempos de carrera de los ciclistas del equipo, en minutos.
     *
     * <p>El enunciado pide que este atributo sea estático. Por ello representa
     * el último total calculado y debe actualizarse con
     * {@link #calcularTotalTiempos()} cada vez que cambien los tiempos. Si se
     * trabaja con varios equipos al mismo tiempo, conviene consultar el valor
     * devuelto por el método y no el atributo estático.</p>
     */
    private static double sumaTiempos = 0.0;

    /** País al que pertenece el equipo. */
    private String pais;

    /** Ciclistas que conforman el equipo. */
    private final List<Ciclista> ciclistas = new ArrayList<>();

    /**
     * Crea un equipo vacío.
     *
     * @param nombre nombre del equipo
     * @param pais   país del equipo
     * @throws IllegalArgumentException si el nombre o el país están vacíos
     */
    public Equipo(String nombre, String pais) {
        setNombre(nombre);
        setPais(pais);
        sumaTiempos = 0.0;
    }

    /**
     * Devuelve el nombre del equipo.
     *
     * @return nombre del equipo
     */
    protected String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del equipo.
     *
     * @param nombre nombre del equipo
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    protected void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del equipo no puede ser nulo ni estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    /**
     * Devuelve la suma de los tiempos del equipo almacenada en el atributo
     * estático.
     *
     * @return suma de tiempos en minutos
     */
    protected static double getSumaTiempos() {
        return sumaTiempos;
    }

    /**
     * Establece el valor del atributo estático de suma de tiempos.
     *
     * @param sumaTiempos suma de tiempos en minutos, mayor o igual que cero
     * @throws IllegalArgumentException si el valor es negativo o no es finito
     */
    protected static void setSumaTiempos(double sumaTiempos) {
        if (!Double.isFinite(sumaTiempos) || sumaTiempos < 0) {
            throw new IllegalArgumentException("La suma de tiempos no puede ser negativa.");
        }
        Equipo.sumaTiempos = sumaTiempos;
    }

    /**
     * Devuelve el país del equipo.
     *
     * @return país del equipo
     */
    protected String getPais() {
        return pais;
    }

    /**
     * Establece el país del equipo.
     *
     * @param pais país del equipo
     * @throws IllegalArgumentException si el país es nulo o está vacío
     */
    protected void setPais(String pais) {
        if (pais == null || pais.isBlank()) {
            throw new IllegalArgumentException("El país del equipo no puede ser nulo ni estar vacío.");
        }
        this.pais = pais.trim();
    }

    /**
     * Devuelve una vista no modificable de los ciclistas del equipo.
     *
     * @return lista de ciclistas
     */
    protected List<Ciclista> getCiclistas() {
        return Collections.unmodifiableList(ciclistas);
    }

    /**
     * Imprime en pantalla los datos del equipo y el total actualizado de sus
     * tiempos.
     */
    protected void imprimir() {
        System.out.println("Nombre del equipo: " + nombre);
        System.out.println("País: " + pais);
        System.out.println("Cantidad de ciclistas: " + ciclistas.size());
        System.out.printf("Total de tiempos: %.2f minutos%n", calcularTotalTiempos());
    }

    /**
     * Añade un ciclista al equipo.
     *
     * <p>No se permiten ciclistas nulos ni ciclistas con un identificador que
     * ya exista dentro del equipo.</p>
     *
     * @param ciclista ciclista que se desea añadir
     * @throws NullPointerException     si el ciclista es nulo
     * @throws IllegalArgumentException si ya existe un ciclista con el mismo
     *                                  identificador
     */
    protected void anadirCiclista(Ciclista ciclista) {
        Objects.requireNonNull(ciclista, "El ciclista no puede ser nulo.");
        if (buscarCiclista(ciclista.getIdentificador()).isPresent()) {
            throw new IllegalArgumentException(
                    "Ya existe un ciclista con el identificador " + ciclista.getIdentificador() + ".");
        }
        ciclistas.add(ciclista);
        calcularTotalTiempos();
    }

    /**
     * Calcula y actualiza la suma de los tiempos de carrera de los ciclistas
     * del equipo.
     *
     * @return suma de los tiempos en minutos
     */
    protected double calcularTotalTiempos() {
        double total = 0.0;
        for (Ciclista ciclista : ciclistas) {
            total += ciclista.getTiempoAcumulado();
        }
        sumaTiempos = total;
        return total;
    }

    /**
     * Devuelve los nombres de todos los ciclistas que conforman el equipo, en
     * el orden en que fueron añadidos.
     *
     * @return lista con los nombres de los ciclistas
     */
    protected List<String> listarNombres() {
        return ciclistas.stream()
                .map(Ciclista::getNombre)
                .toList();
    }

    /**
     * Busca un ciclista por su identificador.
     *
     * @param identificador identificador que se desea buscar
     * @return un {@link Optional} con el ciclista si existe, o vacío si no
     *         existe
     */
    protected Optional<Ciclista> buscarCiclista(int identificador) {
        return ciclistas.stream()
                .filter(ciclista -> ciclista.getIdentificador() == identificador)
                .findFirst();
    }

    @Override
    public String toString() {
        return "Equipo{nombre='" + nombre + "', pais='" + pais
                + "', ciclistas=" + ciclistas.size()
                + ", sumaTiempos=" + sumaTiempos + '}';
    }
}
