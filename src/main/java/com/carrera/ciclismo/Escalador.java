package com.carrera.ciclismo;

/**
 * Ciclista especialista en ascensos y puertos de montaña.
 *
 * <p>Hereda de {@link Ciclista} y añade la aceleración promedio en subida y el
 * grado de rampa soportada. Sus atributos propios son privados y sus métodos
 * específicos son protegidos, tal como indica el enunciado.</p>
 *
 * @version 1.0
 */
public class Escalador extends Ciclista {

    /** Aceleración promedio en subida, en metros por segundo al cuadrado. */
    private float aceleracionPromedioSubida;

    /** Grado de rampa que puede soportar el escalador, en grados. */
    private float gradoRampaSoportada;

    /**
     * Crea un escalador con tiempo acumulado inicial igual a cero.
     *
     * @param identificador            identificador único y positivo
     * @param nombre                   nombre completo del ciclista
     * @param aceleracionPromedioSubida aceleración promedio en m/s2
     * @param gradoRampaSoportada      grado de rampa soportada en grados
     */
    public Escalador(int identificador, String nombre, float aceleracionPromedioSubida,
                     float gradoRampaSoportada) {
        super(identificador, nombre);
        setAceleracionPromedioSubida(aceleracionPromedioSubida);
        setGradoRampaSoportada(gradoRampaSoportada);
    }

    /**
     * Devuelve la aceleración promedio en subida del escalador.
     *
     * @return aceleración promedio en m/s2
     */
    protected float getAceleracionPromedioSubida() {
        return aceleracionPromedioSubida;
    }

    /**
     * Establece la aceleración promedio en subida del escalador.
     *
     * @param aceleracionPromedioSubida aceleración promedio en m/s2
     * @throws IllegalArgumentException si el valor es negativo o no es finito
     */
    protected void setAceleracionPromedioSubida(float aceleracionPromedioSubida) {
        if (!Float.isFinite(aceleracionPromedioSubida) || aceleracionPromedioSubida < 0) {
            throw new IllegalArgumentException("La aceleración promedio en subida no puede ser negativa.");
        }
        this.aceleracionPromedioSubida = aceleracionPromedioSubida;
    }

    /**
     * Devuelve el grado de rampa que soporta el escalador.
     *
     * @return grado de rampa en grados
     */
    protected float getGradoRampaSoportada() {
        return gradoRampaSoportada;
    }

    /**
     * Establece el grado de rampa que soporta el escalador.
     *
     * @param gradoRampaSoportada grado de rampa en grados
     * @throws IllegalArgumentException si el valor es negativo o no es finito
     */
    protected void setGradoRampaSoportada(float gradoRampaSoportada) {
        if (!Float.isFinite(gradoRampaSoportada) || gradoRampaSoportada < 0) {
            throw new IllegalArgumentException("El grado de rampa soportada no puede ser negativo.");
        }
        this.gradoRampaSoportada = gradoRampaSoportada;
    }

    /**
     * Imprime los datos comunes del ciclista y, a continuación, los propios
     * del escalador.
     */
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Aceleración promedio en subida: %.2f m/s2%n", aceleracionPromedioSubida);
        System.out.printf("Grado de rampa soportada: %.2f grados%n", gradoRampaSoportada);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String imprimirTipo() {
        return "Es un Escalador";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                ", aceleracionPromedioSubida=%.2f, gradoRampaSoportada=%.2f",
                aceleracionPromedioSubida, gradoRampaSoportada);
    }
}
