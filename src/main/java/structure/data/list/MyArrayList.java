package structure.data.list;

public class MyArrayList<E> implements MyList<E> {

    // TODO : MyArrayList 구현

    private static final int DEFAULT_CAPACITY = 10;
    private int initCapacity;
    private Object[] elementData;

    public MyArrayList(){
        initCapacity = DEFAULT_CAPACITY;
        elementData = new Object[initCapacity];
    }

    public MyArrayList(int initCapacity){
        elementData = new Object[initCapacity];
    }

    @Override
    public boolean add(E element) {
        return false;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(Object element) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
}
