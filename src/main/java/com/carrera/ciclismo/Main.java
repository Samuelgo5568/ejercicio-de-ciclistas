package com.carrera.ciclismo;

import java.util.Optional;
import java.util.Scanner;


 
public class Main {

    private Main() {
       
    }


    public static void main(String[] args) {
        Equipo equipo = new Equipo("Equipo Élite", "Colombia");

        Velocista velocista = new Velocista(101, "Ana Lucía Gómez", 415.5, 61.8);
        velocista.setTiempoAcumulado(182.5);

        Escalador escalador = new Escalador(102, "Carlos Pérez", 3.8f, 12.5f);
        escalador.setTiempoAcumulado(195.25);

        Contrarrelojista contrarrelojista = new Contrarrelojista(103, "Marta Ruiz", 54.3);
        contrarrelojista.setTiempoAcumulado(178.75);

        equipo.anadirCiclista(velocista);
        equipo.anadirCiclista(escalador);
        equipo.anadirCiclista(contrarrelojista);

        System.out.println("=== DATOS DEL EQUIPO ===");
        equipo.imprimir();

        System.out.println();
        System.out.println("=== CICLISTAS DEL EQUIPO ===");
        for (String nombre : equipo.listarNombres()) {
            System.out.println("- " + nombre);
        }

        System.out.println();
        System.out.printf("Total de tiempos calculado: %.2f minutos%n",
                equipo.calcularTotalTiempos());

        System.out.println();
        buscarCiclistaPorTeclado(equipo);
    }

 
    private static void buscarCiclistaPorTeclado(Equipo equipo) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingrese el identificador del ciclista a buscar: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Entrada no válida: debe ingresar un número entero.");
                return;
            }

            int identificador = scanner.nextInt();
            Optional<Ciclista> encontrado = equipo.buscarCiclista(identificador);

            if (encontrado.isPresent()) {
                System.out.println();
                System.out.println("=== DATOS DEL CICLISTA ENCONTRADO ===");
                encontrado.get().imprimir();
                System.out.println(encontrado.get().imprimirTipo());
            } else {
                System.out.println("No existe un ciclista con el identificador "
                        + identificador + " en el equipo " + equipo.getNombre() + ".");
            }
        }
    }
}
