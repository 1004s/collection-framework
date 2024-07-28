package structure.data.stack;

import structure.data.list.MyArrayList;

import java.util.Iterator;

public class MyStack<E> extends MyArrayList<E> implements IStack<E> , Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return size > index;
            }

            @Override
            public E next() {
                return (E) elementData[index++];
            }
        };
    }

    @Override
    public void push(E item) {
        if(size == initCapacity) {
            throw new StackOverflowError();
        }
        elementData[size++] = item;
    }

    @Override
    public E pop() {
        E element = (E) elementData[size-1];
        size--;
        return element;
    }

    @Override
    public E peek() {
        return (E) elementData[size-1];
    }

    @Override
    public int search(Object o) {
        Iterator<E> iterator = iterator();
        int index = 0;
        while(iterator.hasNext()) {
            if(iterator.next().equals(o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }
}
