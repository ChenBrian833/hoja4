public class SinglyLinkedList<T> extends AbstractList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; this.next = null; }
    }

    private Node<T> head;

    public SinglyLinkedList() {
        super();
        this.head = null;
    }

    @Override
    public void addFirst(T item) {
        Node<T> node = new Node<>(item);
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public T removeFirst() {
        checkNotEmpty();
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        checkNotEmpty();
        return head.data;
    }
}
