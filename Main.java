package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EmptyStackException;

// Clase principal para evaluar expresiones postfix
public class Main {

    public static void main(String[] args) {
     
        StackFactory.TipoPila tipo = StackFactory.TipoPila.VECTOR;

        System.out.println("=== Calculadora Postfix ===");
        System.out.println("Usando pila: " + tipo);
        System.out.println();

        IStack<Integer> pila = StackFactory.crearPila(tipo);
        ICalculadoraPostfix calc = new CalculadoraPostfix(pila);

        // Leer las expresiones del archivo
        String archivo = "datos.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int num = 1;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) {
                    continue;
                }
                System.out.print("Expresion " + num + ": " + linea + " -> ");
                try {
                    int resultado = calc.evaluar(linea);
                    System.out.println("Resultado: " + resultado);
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (EmptyStackException e) {
                    System.out.println("Error: operandos insuficientes");
                }
                num++;
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
}
