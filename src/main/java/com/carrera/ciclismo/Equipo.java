package com.carrera.ciclismo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;



public class Equipo {

   
    private String nombre;


    private static double sumaTiempos = 0.0;

    
    private String pais;

    
    private final List<Ciclista> ciclistas = new ArrayList<>();

    
    public Equipo(String nombre, String pais) {
        setNombre(nombre);
        setPais(pais);
        sumaTiempos = 0.0;
    }


    protected String getNombre() {
        return nombre;
    }


    protected void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del equipo no puede ser nulo ni estar vacío.");
        }
        this.nombre = nombre.trim();
    }

  
    protected static double getSumaTiempos() {
        return sumaTiempos;
    }

  
    protected static void setSumaTiempos(double sumaTiempos) {
        if (!Double.isFinite(sumaTiempos) || sumaTiempos < 0) {
            throw new IllegalArgumentException("La suma de tiempos no puede ser negativa.");
        }
        Equipo.sumaTiempos = sumaTiempos;
    }

    
    protected String getPais() {
        return pais;
    }


    protected void setPais(String pais) {
        if (pais == null || pais.isBlank()) {
            throw new IllegalArgumentException("El país del equipo no puede ser nulo ni estar vacío.");
        }
        this.pais = pais.trim();
    }


    protected List<Ciclista> getCiclistas() {
        return Collections.unmodifiableList(ciclistas);
    }

 
    protected void imprimir() {
        System.out.println("Nombre del equipo: " + nombre);
        System.out.println("País: " + pais);
        System.out.println("Cantidad de ciclistas: " + ciclistas.size());
        System.out.printf("Total de tiempos: %.2f minutos%n", calcularTotalTiempos());
    }

  
  
    protected void anadirCiclista(Ciclista ciclista) {
        Objects.requireNonNull(ciclista, "El ciclista no puede ser nulo.");
        if (buscarCiclista(ciclista.getIdentificador()).isPresent()) {
            throw new IllegalArgumentException(
                    "Ya existe un ciclista con el identificador " + ciclista.getIdentificador() + ".");
        }
        ciclistas.add(ciclista);
        calcularTotalTiempos();
    }

 
    protected double calcularTotalTiempos() {
        double total = 0.0;
        for (Ciclista ciclista : ciclistas) {
            total += ciclista.getTiempoAcumulado();
        }
        sumaTiempos = total;
        return total;
    }

 
    protected List<String> listarNombres() {
        return ciclistas.stream()
                .map(Ciclista::getNombre)
                .toList();
    }

   
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
