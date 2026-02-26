
/**
 * IStack - Interfaz genérica para el ADT Pila.
 * Define el contrato que toda implementación de pila debe cumplir.
 */
public interface IStack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
