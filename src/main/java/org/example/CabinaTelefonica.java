package org.example;

public class CabinaTelefonica {
     private String nombre;
     private int numeroLlamadas;
     private int duracionTotal;
     private double costoTotal;

     private static final double tarifaLocal = 50.0;
     private static final double tarifaLargaDistancia = 350.0;
     private static final double tarifaCelular = 150.0;


     public CabinaTelefonica(String nombreCabina) {
     }

     public CabinaTelefonica(String nombre, int numeroLlamadas, int duracionTotal, double costoTotal) {
         this.nombre = nombre;
         this.numeroLlamadas = numeroLlamadas;
         this.duracionTotal = duracionTotal;
         this.costoTotal = costoTotal;
     }

     public String getNombre() {
         return nombre;
     }

     public void setNombre(String nombre) {
         this.nombre = nombre;
     }

     public int getNumeroLlamadas() {
         return numeroLlamadas;
     }

     public void setNumeroLlamadas(int numeroLlamadas) {
         this.numeroLlamadas = numeroLlamadas;
     }

     public int getDuracionTotal() {
         return duracionTotal;
     }

     public void setDuracionTotal(int duracionTotal) {
         this.duracionTotal = duracionTotal;
     }

     public double getCostoTotal() {
         return costoTotal;
     }

     public void setCostoTotal(double costoTotal) {
         this.costoTotal = costoTotal;
     }


     @Override
     public String toString() {
         return "CabinaTelefonica{" +
                 "nombre='" + nombre + '\'' +
                 ", numeroLlamadas=" + numeroLlamadas +
                 ", duracionTotal=" + duracionTotal +
                 ", costoTotal=" + costoTotal +
                 '}';
     }

     public void registrarLlamada(String tipo, int duracion) {
         numeroLlamadas++;
         duracionTotal += duracion;

         switch (tipo.toLowerCase()) {
             case "local" -> costoTotal += duracion * tarifaLocal;
             case "larga distancia" -> costoTotal += duracion * tarifaLargaDistancia;
             case "celular" -> costoTotal += duracion * tarifaCelular;
             default -> System.out.println("Tipo de llamada no válido.");
         }


     }





     public void reiniciar() {
         numeroLlamadas = 0;
         duracionTotal = 0;
         costoTotal = 0.0;
     }




 }








