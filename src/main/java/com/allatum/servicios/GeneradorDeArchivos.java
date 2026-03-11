package com.allatum.servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivos {
    public void guardarHistorial(List<String> lista) {
        try (FileWriter fileWriter = new FileWriter("historial_consultas.txt")) {
            for (String resultado : lista) {
                fileWriter.write(resultado + "\n");
            }
            System.out.println("Historial guardado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }
}