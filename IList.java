public interface IList<T> {
    void addFirst(T item);
    T removeFirst();
    T getFirst();
    boolean isEmpty();
    int size();
}
