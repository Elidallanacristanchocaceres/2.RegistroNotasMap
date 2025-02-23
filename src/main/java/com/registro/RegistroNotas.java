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
        // 3.lista
        System.out.println("\nLista de estudiantes y sus notas:");
        for (Map.Entry<String, Double> entry : notasEstudiantes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 4.Buscar
        System.out.print("\nIngrese el nombre del estudiante para buscar su nota: ");
        String nombreBuscado = scanner.nextLine();
        if (notasEstudiantes.containsKey(nombreBuscado)) {
            System.out.println("La nota de " + nombreBuscado + " es: " + notasEstudiantes.get(nombreBuscado));
        } else {
            System.out.println("Estudiante no encontrado.");
        }

        // 5.Nota más alta
        String mejorEstudiante = "";
        double mejorNota = -1;
        for (Map.Entry<String, Double> entry : notasEstudiantes.entrySet()) {
            if (entry.getValue() > mejorNota) {
                mejorNota = entry.getValue();
                mejorEstudiante = entry.getKey();
            }
        }

        System.out.println("\nEl estudiante con mejor rendimiento es " + mejorEstudiante + " con una nota de " + mejorNota);
        scanner.close();

        }    
    }