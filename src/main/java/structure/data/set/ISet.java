package structure.data.set;

public interface ISet <E>{

    boolean add(E item);

    boolean remove(E o);

    boolean contains(E o);

    boolean isEmpty();

    int size();

    void clear();

}
