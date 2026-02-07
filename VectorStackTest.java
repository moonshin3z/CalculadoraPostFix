package uvg.edu.gt;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.EmptyStackException;

// Tests para VectorStack
public class VectorStackTest {

    @Test
    public void testPushYPop() {
        IStack<Integer> pila = new VectorStack<>();
        pila.push(10);
        pila.push(20);
        assertEquals(20, (int) pila.pop());
        assertEquals(10, (int) pila.pop());
        assertTrue(pila.isEmpty());
    }

    @Test
    public void testPeek() {
        IStack<Integer> pila = new VectorStack<>();
        pila.push(5);
        assertEquals(5, (int) pila.peek());
        assertEquals(1, pila.size());
    }

    @Test(expected = EmptyStackException.class)
    public void testPopPilaVacia() {
        IStack<Integer> pila = new VectorStack<>();
        pila.pop();
    }
}
