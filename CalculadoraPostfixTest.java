package uvg.edu.gt;

import static org.junit.Assert.*;
import org.junit.Test;

// Tests para la calculadora postfix
public class CalculadoraPostfixTest {

    @Test
    public void testOperacionesBasicas() {
        IStack<Integer> pila = new VectorStack<>();
        ICalculadoraPostfix calc = new CalculadoraPostfix(pila);
        assertEquals(3, calc.evaluar("1 2 +"));
        assertEquals(2, calc.evaluar("5 3 -"));
        assertEquals(12, calc.evaluar("4 3 *"));
        assertEquals(4, calc.evaluar("8 2 /"));
    }

    @Test
    public void testExpresionCompuesta() {
        IStack<Integer> pila = new VectorStack<>();
        ICalculadoraPostfix calc = new CalculadoraPostfix(pila);
        // ((1 + 2) * 4) + 3 = 15
        assertEquals(15, calc.evaluar("1 2 + 4 * 3 +"));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionEntreCero() {
        IStack<Integer> pila = new VectorStack<>();
        ICalculadoraPostfix calc = new CalculadoraPostfix(pila);
        calc.evaluar("5 0 /");
    }
}
