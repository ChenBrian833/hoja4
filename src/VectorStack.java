

import java.util.Vector;

/**
 * VectorStack - Implementación de pila usando java.util.Vector.
 */
public class VectorStack<T> extends AbstractStack<T> {

    private final Vector<T> data;

    public VectorStack() {
        super();
        this.data = new Vector<>();
    }

    @Override
    public void push(T item) {
        data.add(item);
        size++;
    }

    @Override
    public T pop() {
        checkNotEmpty();
        size--;
        return data.remove(data.size() - 1);
    }

    @Override
    public T peek() {
        checkNotEmpty();
        return data.get(data.size() - 1);
    }
}
