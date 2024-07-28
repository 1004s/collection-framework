package structure.data.list;

public class Node<E> {
    // TODO : Node 구현
    private E data;

    private Node next;

    private Node prev;

    public Node(E e) {
        this.data = e;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}