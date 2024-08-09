package structure.data.stack;

import structure.data.list.MyArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyStack<E> extends MyArrayList<E> implements IStack<E> , Iterable<E> {

    // TODO : MyStack 구현

    public MyStack() {
        super();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator() {
        //여기 다시 구현 : null 출력 안되게끔
        Object[] elementData = this.elementData;

        Iterator<E> it = new Iterator<E>() {
            private int idx = 0;

            @Override
            public boolean hasNext() {
                return elementData[idx] != null;
            }

            @Override
            public E next() {
                return (E) elementData[idx++];
            }
        };

        return it;
    }

    @Override
    public void push(E item) {
        add(item);
    }

    @Override
    public E pop() {
        int idx = this.size();
        E element = get(idx - 1);
        remove(idx - 1);
        return element;
    }

    @Override
    public E peek() {
        int idx = this.size();
        return get(idx - 1);
    }

    @Override
    public int search(Object o) {
        return indexOf(o);
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }
}
