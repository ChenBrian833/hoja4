
/**
 * AbstractList - Clase abstracta genérica para el ADT Lista.
 * Provee comportamiento común y deja el almacenamiento a subclases.
 */
public abstract class AbstractList<T> implements IList<T> {

    protected int size;

    public AbstractList() {
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

    protected void checkNotEmpty() {
        if (isEmpty()) {
            throw new RuntimeException("List underflow: la lista está vacía.");
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(size=" + size + ")";
    }
}
