package structure.data.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    MyLinkedList<String> list;

    @BeforeEach
    void setup() {
        list = new MyLinkedList<>();
        list.add("apple");
        list.add("banana");
        list.add("candy");
    }

    @Test
    void addFirst() {
        list.addFirst("Hello");
        assertEquals("Hello", list.getFirst());
    }

    @Test
    void removeFirst() {
        list.removeFirst();
        assertEquals("banana", list.getFirst());
        list.removeFirst();
        assertEquals("candy", list.getFirst());
    }

    @Test
    void removeLast() {
        list.removeLast();
        assertEquals("banana", list.getLast());
    }

    @Test
    void iterator() {
        StringBuilder builder = new StringBuilder();
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            builder.append(iterator.next()).append("-");
        }
        builder.delete(builder.length()-1, builder.length());
        assertEquals("apple-banana-candy", builder.toString());
    }

    @Test
    void addLast() {
        list.addLast("dong");
        assertEquals("dong", list.getLast());
    }

    @Test
    void removeByIndex() {
        list.remove(1);
        assertEquals(2, list.size());
    }

    @Test
    void remove() {
        list.remove("apple");
        assertFalse(list.contains("apple"));
    }

    @Test
    void get() {
        assertEquals("banana", list.get(1));
    }

    @Test
    void set() {
        list.set(1, "baby");
        assertEquals("baby", list.get(1));
    }

    @Test
    void indexOf() {
        assertEquals(1, list.indexOf("banana"));
    }

    @Test
    void contains() {
        assertTrue(list.contains("apple"));
        assertFalse(list.contains("data"));
    }
}