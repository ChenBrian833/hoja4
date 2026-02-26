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
