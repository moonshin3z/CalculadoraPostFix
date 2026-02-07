package uvg.edu.gt;

// Interfaz generica para una pila
public interface IStack<T> {

    // Agrega un elemento al tope
    void push(T value);

    // Saca y retorna el elemento del tope
    T pop();

    // Retorna el elemento del tope sin sacarlo
    T peek();

    // Verifica si la pila esta vacia
    boolean isEmpty();

    // Retorna el numero de elementos
    int size();
}
