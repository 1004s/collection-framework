package structure.data.map;

public class MyHashMap<K,V> implements IMap<K,V> {

    // TODO : MyHashMap 구현

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] table;

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public void remove(K key) {

    }

    @Override
    public int size() {
        return 0;
    }
}
