

import java.util.ArrayList;

/**
 * ArrayListStack - Implementación de pila usando java.util.ArrayList.
 */
public class ArrayListStack<T> extends AbstractStack<T> {

    private final ArrayList<T> data;

    public ArrayListStack() {
        super();
        this.data = new ArrayList<>();
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
