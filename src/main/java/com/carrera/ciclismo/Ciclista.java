package com.carrera.ciclismo;

import java.util.Objects;

/**
 * Representa a un ciclista genérico dentro de una carrera ciclística.
 *
 * <p>Esta clase es abstracta: concentra los datos comunes a todas las
 * especialidades y obliga a las clases hijas a implementar el método
 * {@link #imprimirTipo()}.</p>
 *
 * <p>El tiempo acumulado de carrera se expresa en minutos y siempre comienza
 * en cero. Los atributos son privados y se accede a ellos mediante los métodos
 * get y set correspondientes.</p>
 *
 * @version 1.0
 */
public abstract class Ciclista {

    /** Identificador único del ciclista. */
    private int identificador;

    /** Nombre completo del ciclista. */
    private String nombre;

    /** Tiempo acumulado de carrera, en minutos. */
    private double tiempoAcumulado;

    /**
     * Crea un ciclista con tiempo acumulado inicial igual a cero.
     *
     * @param identificador identificador único y positivo del ciclista
     * @param nombre        nombre completo del ciclista
     * @throws IllegalArgumentException si el identificador no es positivo o
     *                                  si el nombre está vacío
     */
    protected Ciclista(int identificador, String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
        this.tiempoAcumulado = 0.0;
    }

    /**
     * Devuelve el identificador del ciclista.
     *
     * @return identificador del ciclista
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Establece el identificador del ciclista.
     *
     * @param identificador identificador único y positivo
     * @throws IllegalArgumentException si el identificador no es positivo
     */
    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador debe ser mayor que cero.");
        }
        this.identificador = identificador;
    }

    /**
     * Devuelve el nombre del ciclista.
     *
     * @return nombre del ciclista
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del ciclista.
     *
     * @param nombre nombre completo del ciclista
     * @throws IllegalArgumentException si el nombre es nulo o está vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    /**
     * Devuelve el tiempo acumulado de carrera del ciclista.
     *
     * @return tiempo acumulado en minutos
     */
    public double getTiempoAcumulado() {
        return tiempoAcumulado;
    }

    /**
     * Establece el tiempo acumulado de carrera del ciclista.
     *
     * @param tiempoAcumulado tiempo en minutos, mayor o igual que cero
     * @throws IllegalArgumentException si el tiempo es negativo o no es finito
     */
    public void setTiempoAcumulado(double tiempoAcumulado) {
        if (!Double.isFinite(tiempoAcumulado) || tiempoAcumulado < 0) {
            throw new IllegalArgumentException("El tiempo acumulado no puede ser negativo.");
        }
        this.tiempoAcumulado = tiempoAcumulado;
    }

    /**
     * Suma minutos al tiempo acumulado de carrera.
     *
     * @param minutos minutos a acumular, mayores o iguales que cero
     * @throws IllegalArgumentException si los minutos son negativos o no son finitos
     */
    public void acumularTiempo(double minutos) {
        if (!Double.isFinite(minutos) || minutos < 0) {
            throw new IllegalArgumentException("Los minutos a acumular no pueden ser negativos.");
        }
        this.tiempoAcumulado += minutos;
    }

    /**
     * Imprime en pantalla los datos comunes de un ciclista.
     *
     * <p>Las clases hijas deben invocar este método con {@code super.imprimir()}
     * antes de imprimir sus propios atributos.</p>
     */
    public void imprimir() {
        System.out.println("Identificador: " + identificador);
        System.out.println("Nombre: " + nombre);
        System.out.printf("Tiempo acumulado: %.2f minutos%n", tiempoAcumulado);
    }

    /**
     * Devuelve una descripción textual de la especialidad del ciclista.
     *
     * @return texto con el formato {@code "Es un xxx"}, donde {@code xxx} es
     *         la especialidad
     */
    public abstract String imprimirTipo();

    /**
     * Dos ciclistas se consideran iguales cuando tienen el mismo identificador.
     */
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (!(objeto instanceof Ciclista otro)) {
            return false;
        }
        return identificador == otro.identificador;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return String.format("%s{identificador=%d, nombre='%s', tiempoAcumulado=%.2f}",
                getClass().getSimpleName(), identificador, nombre, tiempoAcumulado);
    }
}
