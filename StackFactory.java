package uvg.edu.gt;

// Factory para crear pilas segun el tipo que se necesite
public class StackFactory {

    public enum TipoPila {
        VECTOR,
        ARRAYLIST
    }

    // Crea una pila del tipo indicado
    public static <T> IStack<T> crearPila(TipoPila tipo) {
        switch (tipo) {
            case VECTOR:
                return new VectorStack<>();
            case ARRAYLIST:
                return new ArrayListStack<>();
            default:
                return new VectorStack<>();
        }
    }
}
