package uvg.edu.gt;

import java.util.EmptyStackException;

// Calculadora que evalua expresiones en notacion postfix
public class CalculadoraPostfix implements ICalculadoraPostfix {

    private IStack<Integer> pila;

    public CalculadoraPostfix(IStack<Integer> pila) {
        this.pila = pila;
    }

    @Override
    public int evaluar(String expresion) {
        // Vaciar la pila antes de evaluar
        while (!pila.isEmpty()) {
            pila.pop();
        }

        String[] tokens = expresion.trim().split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (token.isEmpty()) {
                continue;
            }

            if (esOperador(token)) {
                // Se necesitan al menos 2 operandos
                if (pila.size() < 2) {
                    throw new EmptyStackException();
                }
                int b = pila.pop();
                int a = pila.pop();
                int res = operar(a, b, token);
                pila.push(res);
            } else if (esNumero(token)) {
                pila.push(Integer.parseInt(token));
            } else {
                throw new IllegalArgumentException("Token no reconocido: " + token);
            }
        }

        // Al final solo debe quedar un elemento en la pila
        if (pila.size() != 1) {
            throw new IllegalArgumentException("Expresion postfix invalida");
        }

        return pila.pop();
    }

    // Revisa si el token es un operador (+, -, *, /)
    private boolean esOperador(String token) {
        return token.equals("+") || token.equals("-") ||
               token.equals("*") || token.equals("/");
    }

    // Revisa si el token es un numero
    private boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Hace la operacion entre dos numeros
    private int operar(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Division entre cero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operador no valido: " + op);
        }
    }
}
