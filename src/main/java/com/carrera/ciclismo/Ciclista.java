package com.carrera.ciclismo;

import java.util.Objects;


public abstract class Ciclista {

    
    private int identificador;

  
    private String nombre;

    
    private double tiempoAcumulado;

    
    protected Ciclista(int identificador, String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
        this.tiempoAcumulado = 0.0;
    }

  
    public int getIdentificador() {
        return identificador;
    }

 
    public void setIdentificador(int identificador) {
        if (identificador <= 0) {
            throw new IllegalArgumentException("El identificador debe ser mayor que cero.");
        }
        this.identificador = identificador;
    }

  
    public String getNombre() {
        return nombre;
    }

   
    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    
    public double getTiempoAcumulado() {
        return tiempoAcumulado;
    }

  
    public void setTiempoAcumulado(double tiempoAcumulado) {
        if (!Double.isFinite(tiempoAcumulado) || tiempoAcumulado < 0) {
            throw new IllegalArgumentException("El tiempo acumulado no puede ser negativo.");
        }
        this.tiempoAcumulado = tiempoAcumulado;
    }

  
    public void acumularTiempo(double minutos) {
        if (!Double.isFinite(minutos) || minutos < 0) {
            throw new IllegalArgumentException("Los minutos a acumular no pueden ser negativos.");
        }
        this.tiempoAcumulado += minutos;
    }

    
    public void imprimir() {
        System.out.println("Identificador: " + identificador);
        System.out.println("Nombre: " + nombre);
        System.out.printf("Tiempo acumulado: %.2f minutos%n", tiempoAcumulado);
    }

    
   
    public abstract String imprimirTipo();

   
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
