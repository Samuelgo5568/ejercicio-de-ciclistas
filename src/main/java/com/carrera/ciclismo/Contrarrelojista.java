package com.carrera.ciclismo;


public class Contrarrelojista extends Ciclista {

    private double velocidadMaxima;

   
    public Contrarrelojista(int identificador, String nombre, double velocidadMaxima) {
        super(identificador, nombre);
        setVelocidadMaxima(velocidadMaxima);
    }

  
    protected double getVelocidadMaxima() {
        return velocidadMaxima;
    }

  
    protected void setVelocidadMaxima(double velocidadMaxima) {
        if (!Double.isFinite(velocidadMaxima) || velocidadMaxima < 0) {
            throw new IllegalArgumentException("La velocidad máxima no puede ser negativa.");
        }
        this.velocidadMaxima = velocidadMaxima;
    }

   
    @Override
    public void imprimir() {
        super.imprimir();
        System.out.printf("Velocidad máxima: %.2f km/h%n", velocidadMaxima);
    }


    @Override
    public String imprimirTipo() {
        return "Es un Contrarrelojista";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", velocidadMaxima=%.2f", velocidadMaxima);
    }
}
