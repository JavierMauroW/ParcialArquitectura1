package org.example;


import org.example.CabinaTelefonica;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CabinaTelefonica> cabinas = new ArrayList<>();

        while (true) {
            System.out.println("1. Crear cabina telefónica");
            System.out.println("2. Escoger cabina telefónica y registrar llamada");
            System.out.println("3. Mostrar información detallada por cabina");
            System.out.println("4. Mostrar consolidado total de todas las cabinas");
            System.out.println("5. Reiniciar uso de cabina telefónica");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el nombre de la cabina: ");
                    String nombreCabina = scanner.nextLine();
                    cabinas.add(new CabinaTelefonica(nombreCabina));
                    System.out.println("Cabina creada con éxito.");
                }
                case 2 -> {
                    System.out.print("Ingrese el nombre de la cabina: ");
                    String nombre = scanner.nextLine();
                    CabinaTelefonica cabinaSeleccionada = null;

                    for (CabinaTelefonica cabina : cabinas) {
                        if (cabina.getNombre().equalsIgnoreCase(nombre)) {
                            cabinaSeleccionada = cabina;
                            break;
                        }



                    }

                    if (cabinaSeleccionada != null) {
                        System.out.print("Ingrese el tipo de llamada : ");
                        String tipoLlamada = scanner.nextLine();
                        System.out.print("Ingrese la duración de la llamada en minutos: ");
                        int duracion = scanner.nextInt();
                        cabinaSeleccionada.registrarLlamada(tipoLlamada, duracion);
                        System.out.println("Llamada registrada con éxito.");
                    }





                }

                case 3 -> {
                    for (CabinaTelefonica cabina : cabinas) {
                        System.out.println(cabina);
                        System.out.println();
                    }
                }
                case 4 -> {
                    int totalLlamadas = 0;
                    int totalDuracion = 0;
                    double totalCosto = 0.0;

                    for (CabinaTelefonica cabina : cabinas) {
                        totalLlamadas += cabina.getNumeroLlamadas();
                        totalDuracion += cabina.getDuracionTotal();
                        totalCosto += cabina.getCostoTotal();
                    }

                    System.out.println("Consolidado total:");
                    System.out.println("Número total de llamadas: " + totalLlamadas);
                    System.out.println("Duración total de llamadas: " + totalDuracion + " minutos");
                    System.out.println("Costo total de llamadas: $" + totalCosto);
                }
                case 5 -> {
                    System.out.print("Ingrese el nombre de la cabina a reiniciar: ");
                    String nombre = scanner.nextLine();
                    CabinaTelefonica cabinaSeleccionada = null;

                    for (CabinaTelefonica cabina : cabinas) {
                        if (cabina.getNombre().equalsIgnoreCase(nombre)) {
                            cabinaSeleccionada = cabina;
                            break;
                        }
                    }

                    if (cabinaSeleccionada != null) {
                        cabinaSeleccionada.reiniciar();
                        System.out.println("Cabina reiniciada con éxito.");
                    } else {
                        System.out.println("Cabina no encontrada.");
                    }
                }
                case 6 -> {
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }


                }

            }
        }

