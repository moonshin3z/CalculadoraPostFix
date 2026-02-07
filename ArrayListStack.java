package uvg.edu.gt;

import java.util.ArrayList;
import java.util.EmptyStackException;

// Implementacion de pila usando ArrayList
public class ArrayListStack<T> implements IStack<T> {

    private ArrayList<T> datos;

    public ArrayListStack() {
        datos = new ArrayList<>();
    }

    @Override
    public void push(T value) {
        datos.add(value);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return datos.remove(datos.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return datos.get(datos.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return datos.isEmpty();
    }

    @Override
    public int size() {
        return datos.size();
    }

    @Override
    public String toString() {
        return datos.toString();
    }
}
