package structure.data.set;

import structure.data.map.MyHashMap;

import java.util.HashSet;
import java.util.Iterator;

public class MyHashSet<E> implements ISet<E>, Iterable<E> {

    //dummy object value;
    private static final Object PRESENT = new Object();
    private MyHashMap<E,Object> map = new MyHashMap<>();

    @Override
    public boolean add(E item) {
        if(map.containsKey(item)) {
            return false;
        }
        map.put(item, PRESENT);
        return true;
    }

    @Override
    public boolean remove(E o) {
        if(map.containsKey(o)) {
            map.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E o) {
        return map.containsKey(o);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}
