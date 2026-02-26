

import list.IList;

/**
 * ListStack - Implementación de pila usando un ADT Lista.
 * La implementación concreta de lista es decidida por ListFactory.
 */
public class ListStack<T> extends AbstractStack<T> {

    private final IList<T> list;

    public ListStack(IList<T> list) {
        super();
        this.list = list;
    }

    @Override
    public void push(T item) {
        list.addFirst(item);
        size++;
    }

    @Override
    public T pop() {
        checkNotEmpty();
        size--;
        return list.removeFirst();
    }

    @Override
    public T peek() {
        checkNotEmpty();
        return list.getFirst();
    }
}
