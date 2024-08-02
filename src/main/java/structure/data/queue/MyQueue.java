package structure.data.queue;

import structure.data.list.MyLinkedList;

import java.util.NoSuchElementException;

public class MyQueue<E> extends MyLinkedList<E> implements IQueue<E> {

    @Override
    public E element() {
        if(size == 0 || head == null) {
            throw new NoSuchElementException();
        }
        return head.getData();
    }

    @Override
    public boolean offer(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E poll() {
        if(head == null) {
            return null;
        }
        return removeFirst();
    }

    @Override
    public E peek() {
        if(head == null) {
            return null;
        }
        return head.getData();
    }
}