package com.carrera.ciclismo;


public class Escalador extends Ciclista {

    
    private float aceleracionPromedioSubida;

    /** Grado de rampa que puede soportar el escalador, en grados. */
    private float gradoRampaSoportada;

    
    public Escalador(int identificador, String nombre, float aceleracionPromedioSubida,
                     float gradoRampaSoportada) {
        super(identificador, nombre);
        setAceleracionPromedioSubida(aceleracionPromedioSubida);
        setGradoRampaSoportada(gradoRampaSoportada);
    }

   
    protected float getAceleracionPromedioSubida() {
        return aceleracionPromedioSubida;
    }


    protected void setAceleracionPromedioSubida(float aceleracionPromedioSubida) {
        if (!Float.isFinite(aceleracionPromedioSubida) || aceleracionPromedioSubida < 0) {
            throw new IllegalArgumentException("La aceleración promedio en subida no puede ser negativa.");
        }
        this.aceleracionPromedioSubida = aceleracionPromedioSubida;
    }


    protected float getGradoRampaSoportada() {
        return gradoRampaSoportada;
    }

  
    protected void setGradoRampaSoportada(float gradoRampaSoportada) {
        if (!Float.isFinite(gradoRampaSoportada) || gradoRampaSoportada < 0) {
            throw new IllegalArgumentException("El grado de rampa soportada no puede ser negativo.");
        }
        this.gradoRampaSoportada = gradoRampaSoportada;
    }

    
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Aceleración promedio en subida: %.2f m/s2%n", aceleracionPromedioSubida);
        System.out.printf("Grado de rampa soportada: %.2f grados%n", gradoRampaSoportada);
    }

  
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
