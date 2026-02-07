package uvg.edu.gt;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.EmptyStackException;

// Tests para ArrayListStack
public class ArrayListStackTest {

    @Test
    public void testPushYPop() {
        IStack<Integer> pila = new ArrayListStack<>();
        pila.push(10);
        pila.push(20);
        assertEquals(20, (int) pila.pop());
        assertEquals(10, (int) pila.pop());
        assertTrue(pila.isEmpty());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopPilaVacia() {
        IStack<Integer> pila = new ArrayListStack<>();
        pila.pop();
    }
}
