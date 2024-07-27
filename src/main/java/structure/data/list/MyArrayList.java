package structure.data.list;

public class MyArrayList<E> implements MyList<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private int initCapacity;
    private Object[] elementData;
    private int size;

    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initCapacity){
        this.elementData = new Object[initCapacity];
        this.initCapacity = initCapacity;
        this.size = 0;
    }

    @Override
    public boolean add(E element) {
        elementData[size++] = element;
        return true;
    }

    @Override
    public boolean remove(int index) {
        System.arraycopy(elementData, index + 1, elementData, index, size - index);
        size--;
        return true;
    }

    @Override
    public boolean remove(E e) {
        for(int i = 0; i < size; i++) {
            if(elementData[i].equals(e)) {
                System.arraycopy(elementData, i + 1, elementData, i, size-i);
                size--;
            }
        }

        return true;
    }

    @Override
    public E get(int index) {
        return (E)elementData[index];
    }

    @Override
    public E set(int index, E element) {
        System.arraycopy(elementData, index, elementData, index+1, size-index);
        elementData[index] = element;
        size++;
        return element;
    }

    @Override
    public int indexOf(Object element) {
        for(int i = 0; i < size; i++) {
            if(elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < size; i++) {
            if(elementData[i].equals((E)o)) {
                return true;
            }
        }
        return false;
    }
}
