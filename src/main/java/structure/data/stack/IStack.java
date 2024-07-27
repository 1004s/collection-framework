package structure.data.stack;

interface IStack<E> {

    void push(E item);

    E pop();

    E peek();

    int search(Object o);

    boolean empty();
}
