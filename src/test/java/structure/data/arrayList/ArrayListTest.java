package structure.data.arrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    List<Integer> list;

    @BeforeEach
    void setup() {
        list = new ArrayList<>();
    }

    @Test
    void add() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("index를 이용하여 삭제")
    void removeByIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.remove(1);

        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
        assertEquals(4, list.get(2));
        assertEquals(5, list.get(3));
        assertEquals(4, list.size());

    }

    @Test
    @DisplayName("value를 이용하여 삭제")
    void remove() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("c");
        list.add("e");

        list.remove("c");
        assertEquals("d", list.get(2));
        assertEquals("e", list.get(3));
        assertEquals(4, list.size());
    }


    @Test
    void set() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.set(1, 5);

        assertEquals(5, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(4, list.size());
    }

    @Test
    void indexOf() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.indexOf(2));
    }

    @Test
    void contains() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(2));
        assertFalse(list.contains(0));
    }
}