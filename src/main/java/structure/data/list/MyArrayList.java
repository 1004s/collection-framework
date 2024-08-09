package structure.data.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    // TODO : MyArrayList 구현

    private static final int DEFAULT_CAPACITY = 10;
    private int initCapacity;
    protected Object[] elementData;
    private int size;

    public MyArrayList(){
        initCapacity = DEFAULT_CAPACITY;
        elementData = new Object[initCapacity];
    }

    public MyArrayList(int initCapacity){
        elementData = new Object[initCapacity];
    }

    /*
     *  다 차있으면 크기 2배로 늘리기
     */
    @Override
    public boolean add(E element) {
        if (size == elementData.length) {
            initCapacity = initCapacity * 2;
            this.elementData = Arrays.copyOf(this.elementData, elementData.length * 2);
        }

        this.elementData[size] = element;
        this.size++;
        return true;
    }

    /*
     * index 번째 요소 삭제
     */
    @Override
    public boolean remove(int index) {
        Object[] newElementData = new Object[this.initCapacity];

        if (index == 0) {    // 첫 번째 요소 삭제
            System.arraycopy(this.elementData, 1, newElementData, 0, size-1);
        } else if (index == size - 1) { // 마지막 요소 삭제
            System.arraycopy(this.elementData, 0, newElementData, 0, size-1);
        } else {
            System.arraycopy(this.elementData,0, newElementData, 0, index);
            System.arraycopy(this.elementData,index+1,newElementData,index,size-index+1);
        }

        this.elementData = newElementData;
        size--;
        return true;
    }

    /*
     * 동일한 요소 삭제, remove first
     */
    @Override
    public boolean remove(E e) {

        for (int i = 0; i < size; i++) {
            if (this.elementData[i].equals(e)) {
                System.arraycopy(elementData,i+1,elementData,i,size - i + 1);
                break;
            }
        }

        size--;
        return true;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public E get(int index) {
        return (E) this.elementData[index];
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public E set(int index, E element) {
        E original = (E) elementData[index];
        this.elementData[index] = element;
        return original;
    }

    @Override
    public int indexOf(Object element) {
        int idx = 0;
        for (int i = 0; i < size; i++) {
            if (this.elementData[i].equals(element)) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(Object o) {
        boolean isContains = false;
        for (int i = 0; i < size; i++) {
            if (this.elementData[i].equals(o)) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }
}
