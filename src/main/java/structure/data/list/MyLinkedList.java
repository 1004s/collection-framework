package structure.data.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> , MyList<E> , Iterable<E> {

    private Node<E> head;

    private Node<E> tail;

    private int size = 0;

    @Override
    public void addFirst(E e) {
        Node<E> headNode = head;
        Node<E> newNode = new Node<>(e);
        newNode.setNext(headNode);
        head = newNode;

        if(headNode == null) {
            tail = newNode;
        } else {
            headNode.setPrev(newNode);
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> tailNode = tail;
        Node<E> newNode = new Node<>(e);
        newNode.setPrev(tailNode);
        tail = newNode;

        if(tailNode == null) {
            head = newNode;
        } else {
            tailNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if (size == 0 || head == null) {
            throw new NoSuchElementException();
        }

        Node<E> headNode = head;
        final E headElement = headNode.getData();
        final Node<E> nextNode = headNode.getNext();

        headNode.setData(null);
        headNode.setNext(null);

        head = nextNode;
        if(nextNode == null) {
            tail = null;
        } else {
            nextNode.setPrev(null);
        }
        size--;
        return headElement;
    }

    @Override
    public E removeLast() {
        if (size == 0 || tail == null) {
            throw new NoSuchElementException();
        }

        Node<E> tailNode = tail;
        final E tailData = tailNode.getData();
        final Node<E> prevNode = tailNode.getPrev();

        tailNode.setData(null);
        tailNode.setPrev(null);

        tail = prevNode;
        if(prevNode == null) {
            head = null;
        } else {
            prevNode.setNext(null);
        }
        size--;
        return tailData;
    }

    @Override
    public E getFirst() {
        if(size == 0 || head == null) {
            throw  new NoSuchElementException();
        }
        return head.getData();
    }

    @Override
    public E getLast() {
        if(size == 0 || tail == null) {
            throw  new NoSuchElementException();
        }
        return tail.getData();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode == null;
            }

            @Override
            public E next() {
                final E data = currentNode.getData();
                currentNode = currentNode.getNext();
                return data;

            }
        };
    }

    @Override
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    @Override
    public boolean remove(int index) {
        Node<E> node = fetchNodeByIndex(index);
        unlinkAndDecrementSize(node);
        return true;
    }

    @Override
    public boolean remove(E e) {
        // 내부 data가 e인 첫번째 요소 삭제
        Node<E> node = head;
        while(node.getNext() != null) {
            if(node.getData().equals(e)) {
                unlinkAndDecrementSize(node);
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public E get(int index) {
        return fetchNodeByIndex(index).getData();
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = fetchNodeByIndex(index);
        final E originalData = node.getData();
        node.setData(element);
        return originalData;
    }

    @Override
    public int indexOf(Object element) {
        Node<E> node = head;
        int index = 0;
        while(index < size) {
            if (node.getData().equals(element)) {
                return index;
            }
            node = node.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    private void unlinkAndDecrementSize(Node<E> target) {
        final Node<E> prevNode = target.getPrev();
        final Node<E> nextNode = target.getNext();

        target.setPrev(null);
        target.setNext(null);
        target.setData(null);

        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.setNext(nextNode);
        }

        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.setPrev(prevNode);
        }
        size--;
    }

    private Node<E> fetchNodeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<E> node = head;
        for(int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }
}

