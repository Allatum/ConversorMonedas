package com.allatum.principal;

import com.allatum.modelos.Calculos;
import com.allatum.servicios.ConsultaConversion;
import com.allatum.servicios.GeneradorDeArchivos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaConversion consulta = new ConsultaConversion();
        Calculos calculos = new Calculos(consulta);
        GeneradorDeArchivos generador = new GeneradorDeArchivos();
        List<String> respuestas = new ArrayList<>();

        int opcionElegida = 0;

        String[][] paresMonedas = {
                {"PYG", "USD"}, // Opcion 1
                {"PYG", "EUR"}, // Opcion 2
                {"PYG", "GBP"}, // Opcion 3
                {"USD", "PYG"}, // Opcion 4
                {"EUR", "PYG"}, // Opcion 5
                {"GBP", "PYG"}  // Opcion 6
        };

        String menu = """
                \n***************************************************
                *** Sea bienvenido al Conversor de Monedas ***
                
                1) Guaraní ==>> Dólar Estadounidense
                2) Guaraní ==>> Euro
                3) Guaraní ==>> Libra Esterlina
                4) Dólar Estadounidense ==>> Guaraní
                5) Euro ==>> Guaraní
                6) Libra Esterlina ==>> Guaraní
                7) Otra opción de conversión
                8) Salir
                ***************************************************
                """;

        while (opcionElegida != 8) {
            try {
                System.out.println(menu);
                System.out.print("Elija una opción: ");
                opcionElegida = Integer.parseInt(lectura.nextLine());

                if (opcionElegida == 8) break;

                String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

                if (opcionElegida >= 1 && opcionElegida <= 6) {
                    String base = paresMonedas[opcionElegida - 1][0];
                    String objetivo = paresMonedas[opcionElegida - 1][1];

                    System.out.println("Ingrese el valor que desea convertir:");
                    double cantidad = Double.parseDouble(lectura.nextLine());

                    calculos.almacenarValores(base, objetivo, cantidad);
                    respuestas.add(fecha + " - " + calculos.obtenerMensajeRespuesta());

                } else if (opcionElegida == 7) {
                    calculos.almacenarValoresPersonalizados(lectura);
                    respuestas.add(fecha + " - " + calculos.obtenerMensajeRespuesta());

                } else {
                    System.out.println("Por favor, ingrese una opción válida (1-8).");
                }

            } catch (Exception e) {
                System.out.println("Error: Verifique que el valor ingresado sea correcto.");
            }
        }

        if (!respuestas.isEmpty()) {
            generador.guardarHistorial(respuestas);
        }
        System.out.println("Programa finalizado con éxito.");
    }
}