package structure.data.map;

import java.util.Objects;

public class MyHashMap<K,V> implements IMap<K,V> {

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private Object[] table;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Object[capacity];
    }

    @Override
    public void clear() {
        for(int i = 0; i < capacity; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        int hash = getIndex(key);
        if(table[hash] == null) {
            return false;
        }
        HashNode<K, V> node = (HashNode<K, V>) table[hash];
        if(node.getKey().equals(key)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for(int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                V v = ((HashNode<K,V>) table[i]).getValue();
                if(v.equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int hash = getIndex(key);
        if(table[hash] == null) {
            return null;
        }
        return ((HashNode<K,V>) table[hash]).getValue();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int hash = getIndex(key);

        if(table[hash] == null) {
            table[hash] = new HashNode<>(hash, key, value);
            size++;
            return null;
        } else {
            HashNode<K,V> node = (HashNode<K, V>) table[hash];
            V oldValue = node.getValue();
            node.setValue(value);
            return oldValue;
        }
    }

    @Override
    public void remove(K key) {
        int idx = getIndex(key);
        if(table[idx] == null) {
            return;
        }
        table[idx] = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        return Math.abs(Objects.hashCode(key)) % capacity;
    }
}
