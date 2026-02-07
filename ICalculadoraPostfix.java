package uvg.edu.gt;

// Interfaz para la calculadora postfix
public interface ICalculadoraPostfix {

    /**
     * Evalua una expresion en notacion postfix.
     * @param expresion operandos y operadores separados por espacios.
     * @return resultado de la evaluacion.
     * Precondicion: la expresion debe tener operandos enteros y operadores +, -, *, / separados por espacios.
     * Postcondicion: retorna el resultado entero de evaluar la expresion.
     */
    int evaluar(String expresion);
}
