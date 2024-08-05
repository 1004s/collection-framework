package structure.data.set;

import structure.data.map.MyHashMap;

import java.util.Iterator;

public class MyHashSet<E> implements ISet<E>, Iterable<E> {

    // TODO : MyHashSet 구현

    //dummy object value;
    private static final Object PRESENT = new Object();
    private MyHashMap<E,Object> map = new MyHashMap<>();

    @Override
    public boolean add(E item) {

        return false;
    }

    @Override
    public boolean remove(E o) {

        return false;
    }

    @Override
    public boolean contains(E o) {

        return false;
    }

    @Override
    public boolean isEmpty() {

        return false;
    }

    @Override
    public int size() {

        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
