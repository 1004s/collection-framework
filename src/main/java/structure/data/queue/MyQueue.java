package structure.data.queue;

import structure.data.list.MyLinkedList;

public class MyQueue<E> extends MyLinkedList<E> implements IQueue<E> {

    // TODO : MyQueue 구현

    @Override
    public E element() {
        return null;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}