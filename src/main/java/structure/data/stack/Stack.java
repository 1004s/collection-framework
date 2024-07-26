package structure.data.stack;

interface Stack<E> {

    void push(E item);

    E pop();

    E peek();

    int search(Object o);

    boolean empty();
}
