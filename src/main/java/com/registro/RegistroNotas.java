package com.registro;

import java.util.*;


public class RegistroNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US); // Asegura el uso del punto como decimal
        Map<String, Double> notasEstudiantes = new HashMap<>();

        // 1.cantidad 
        System.out.print("Ingrese la cantidad de estudiantes: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); 

        // 2.nombres y notas
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            String nombre = scanner.nextLine();

            double nota;
            while (true) {
                try {
                    System.out.print("Cual es la nota " + nombre + " (Puedes colocar decimal): ");
                    nota = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Ingrese un número válido.");
                }
            }

            notasEstudiantes.put(nombre, nota);
        }
        }    
    }