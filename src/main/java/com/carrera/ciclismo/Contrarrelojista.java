package com.carrera.ciclismo;

/**
 * Ciclista especialista en pruebas contrarreloj.
 *
 * <p>Hereda de {@link Ciclista} y añade la velocidad máxima que puede
 * alcanzar. Sus atributos propios son privados y sus métodos específicos son
 * protegidos, tal como indica el enunciado.</p>
 *
 * @version 1.0
 */
public class Contrarrelojista extends Ciclista {

    /** Velocidad máxima del contrarrelojista, en kilómetros por hora. */
    private double velocidadMaxima;

    /**
     * Crea un contrarrelojista con tiempo acumulado inicial igual a cero.
     *
     * @param identificador  identificador único y positivo
     * @param nombre         nombre completo del ciclista
     * @param velocidadMaxima velocidad máxima en km/h
     */
    public Contrarrelojista(int identificador, String nombre, double velocidadMaxima) {
        super(identificador, nombre);
        setVelocidadMaxima(velocidadMaxima);
    }

    /**
     * Devuelve la velocidad máxima del contrarrelojista.
     *
     * @return velocidad máxima en km/h
     */
    protected double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Establece la velocidad máxima del contrarrelojista.
     *
     * @param velocidadMaxima velocidad máxima en km/h
     * @throws IllegalArgumentException si el valor es negativo o no es finito
     */
    protected void setVelocidadMaxima(double velocidadMaxima) {
        if (!Double.isFinite(velocidadMaxima) || velocidadMaxima < 0) {
            throw new IllegalArgumentException("La velocidad máxima no puede ser negativa.");
        }
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Imprime los datos comunes del ciclista y, a continuación, los propios
     * del contrarrelojista.
     */
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Velocidad máxima: %.2f km/h%n", velocidadMaxima);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String imprimirTipo() {
        return "Es un Contrarrelojista";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", velocidadMaxima=%.2f", velocidadMaxima);
    }
}
