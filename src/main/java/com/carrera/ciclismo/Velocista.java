package com.carrera.ciclismo;

/**
 * Ciclista especialista en sprints y llegadas masivas.
 *
 * <p>Hereda de {@link Ciclista} y añade la potencia promedio y la velocidad
 * promedio en sprint. Sus atributos propios son privados y sus métodos
 * específicos son protegidos, tal como indica el enunciado.</p>
 *
 * @version 1.0
 */
public class Velocista extends Ciclista {

    /** Potencia promedio del velocista, en vatios. */
    private double potenciaPromedio;

    /** Velocidad promedio en sprint, en kilómetros por hora. */
    private double velocidadPromedioSprint;

    /**
     * Crea un velocista con tiempo acumulado inicial igual a cero.
     *
     * @param identificador           identificador único y positivo
     * @param nombre                  nombre completo del ciclista
     * @param potenciaPromedio        potencia promedio en vatios
     * @param velocidadPromedioSprint velocidad promedio en sprint en km/h
     */
    public Velocista(int identificador, String nombre, double potenciaPromedio,
                     double velocidadPromedioSprint) {
        super(identificador, nombre);
        setPotenciaPromedio(potenciaPromedio);
        setVelocidadPromedioSprint(velocidadPromedioSprint);
    }

    /**
     * Devuelve la potencia promedio del velocista.
     *
     * @return potencia promedio en vatios
     */
    protected double getPotenciaPromedio() {
        return potenciaPromedio;
    }

    /**
     * Establece la potencia promedio del velocista.
     *
     * @param potenciaPromedio potencia promedio en vatios
     * @throws IllegalArgumentException si el valor es negativo o no es finito
     */
    protected void setPotenciaPromedio(double potenciaPromedio) {
        if (!Double.isFinite(potenciaPromedio) || potenciaPromedio < 0) {
            throw new IllegalArgumentException("La potencia promedio no puede ser negativa.");
        }
        this.potenciaPromedio = potenciaPromedio;
    }

    /**
     * Devuelve la velocidad promedio en sprint del velocista.
     *
     * @return velocidad promedio en km/h
     */
    protected double getVelocidadPromedioSprint() {
        return velocidadPromedioSprint;
    }

    /**
     * Establece la velocidad promedio en sprint del velocista.
     *
     * @param velocidadPromedioSprint velocidad promedio en km/h
     * @throws IllegalArgumentException si el valor es negativo o no es finito
     */
    protected void setVelocidadPromedioSprint(double velocidadPromedioSprint) {
        if (!Double.isFinite(velocidadPromedioSprint) || velocidadPromedioSprint < 0) {
            throw new IllegalArgumentException("La velocidad promedio en sprint no puede ser negativa.");
        }
        this.velocidadPromedioSprint = velocidadPromedioSprint;
    }

    /**
     * Imprime los datos comunes del ciclista y, a continuación, los propios
     * del velocista.
     */
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Potencia promedio: %.2f W%n", potenciaPromedio);
        System.out.printf("Velocidad promedio en sprint: %.2f km/h%n", velocidadPromedioSprint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String imprimirTipo() {
        return "Es un Velocista";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                ", potenciaPromedio=%.2f, velocidadPromedioSprint=%.2f",
                potenciaPromedio, velocidadPromedioSprint);
    }
}
