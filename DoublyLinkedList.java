public class DoublyLinkedList<T> extends AbstractList<T> {

    private static class Node<T> {
        T data;
        Node<T> prev, next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;

    public DoublyLinkedList() {
        super();
        this.head = null;
    }

    @Override
    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        size++;
    }

    @Override
    public T removeFirst() {
        checkNotEmpty();
        T data = head.data;
        head = head.next;
        if (head != null) head.prev = null;
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        checkNotEmpty();
        return head.data;
    }
}
