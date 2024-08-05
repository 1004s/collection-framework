package structure.data.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

    MyHashSet<String> myHashSet;

    @BeforeEach
    void setup() {
        myHashSet = new MyHashSet<>();
    }

    @Test
    void add() {
        myHashSet.add("abcde");
        myHashSet.add("abcde");
        myHashSet.add("abcde");
        myHashSet.add("fghij");
        assertEquals(2, myHashSet.size());
    }

    @Test
    void remove() {
        myHashSet.add("abcde");
        myHashSet.add("fghij");

        myHashSet.remove("abcde");
        assertEquals(1, myHashSet.size());
        assertFalse(myHashSet.contains("abcde"));
    }

    @Test
    void contains() {
        assertFalse(myHashSet.contains("dummy-key"));

        myHashSet.add("my-key");
        assertTrue(myHashSet.contains("my-key"));
    }

    @Test
    void clear() {
        myHashSet.add("abcde");
        myHashSet.add("abcde");
        myHashSet.add("abcde");
        myHashSet.add("fghij");
        myHashSet.add("klmno");

        myHashSet.clear();

        assertEquals(0, myHashSet.size());
    }

    @Test
    void iterator() {
        myHashSet.add("abcde");
        myHashSet.add("fghi");

        Iterator<String> iterator = myHashSet.iterator();
        StringBuilder builder = new StringBuilder();
        while(iterator.hasNext()) {
            builder.append(iterator.next());
        }
        assertEquals("abcdefghi", builder.toString());
    }
}