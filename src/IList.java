
/**
 * IList - Interfaz genérica para el ADT Lista.
 * Solo define las operaciones necesarias para soportar una pila.
 */
public interface IList<T> {
    void addFirst(T item);
    T removeFirst();
    T getFirst();
    boolean isEmpty();
    int size();
}
