
/**
 * AbstractStack - Clase abstracta genérica para el ADT Pila.
 * Implementa comportamiento común y deja a las subclases
 * definir el almacenamiento interno.
 */
public abstract class AbstractStack<T> implements IStack<T> {

    protected int size;

    public AbstractStack() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Verifica que la pila no esté vacía antes de pop/peek.
     */
    protected void checkNotEmpty() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow: la pila está vacía.");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(size=" + size + ")";
    }
}
