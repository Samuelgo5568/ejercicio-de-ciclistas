package com.carrera.ciclismo;

public class Velocista extends Ciclista {

  
    private double potenciaPromedio;

    
    private double velocidadPromedioSprint;

  
    public Velocista(int identificador, String nombre, double potenciaPromedio,
                     double velocidadPromedioSprint) {
        super(identificador, nombre);
        setPotenciaPromedio(potenciaPromedio);
        setVelocidadPromedioSprint(velocidadPromedioSprint);
    }

    
    protected double getPotenciaPromedio() {
        return potenciaPromedio;
    }

 
    protected void setPotenciaPromedio(double potenciaPromedio) {
        if (!Double.isFinite(potenciaPromedio) || potenciaPromedio < 0) {
            throw new IllegalArgumentException("La potencia promedio no puede ser negativa.");
        }
        this.potenciaPromedio = potenciaPromedio;
    }

  
    protected double getVelocidadPromedioSprint() {
        return velocidadPromedioSprint;
    }


    protected void setVelocidadPromedioSprint(double velocidadPromedioSprint) {
        if (!Double.isFinite(velocidadPromedioSprint) || velocidadPromedioSprint < 0) {
            throw new IllegalArgumentException("La velocidad promedio en sprint no puede ser negativa.");
        }
        this.velocidadPromedioSprint = velocidadPromedioSprint;
    }

  
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Potencia promedio: %.2f W%n", potenciaPromedio);
        System.out.printf("Velocidad promedio en sprint: %.2f km/h%n", velocidadPromedioSprint);
    }

  
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
