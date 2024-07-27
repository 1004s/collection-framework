package structure.data.stack;

import structure.data.list.MyArrayList;

import java.util.Iterator;

public class MyStack<E> extends MyArrayList<E> implements IStack<E> , Iterable<E> {

    // TODO : MyStack 구현

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void push(E item) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int search(Object o) {
        return 0;
    }

    @Override
    public boolean empty() {
        return false;
    }
}
