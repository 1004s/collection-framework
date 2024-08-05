package structure.data.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    MyHashMap<String, String> myHashMap;

    @BeforeEach
    void setup() {
        myHashMap = new MyHashMap<>();
    }

    @Test
    void clear() {
        myHashMap.put("a","aa");
        myHashMap.put("b","Bb");
        myHashMap.clear();
        assertEquals(0, myHashMap.size());
    }

    @Test
    void containsKey() {
        assertFalse(myHashMap.containsKey("test-key"));
        myHashMap.put("test-key", "test-value");
        assertTrue(myHashMap.containsKey("test-key"));
    }

    @Test
    void containsValue() {
        myHashMap.put("test-key", "test-value");
        assertTrue(myHashMap.containsValue("test-value"));
    }

    @Test
    void get() {
        myHashMap.put("a", "aaa");
        assertEquals("aaa", myHashMap.get("a"));
        myHashMap.put("a", "ddd");
        assertEquals("ddd", myHashMap.get("a"));

        assertNull(myHashMap.get("bb"));
    }

    @Test
    void isEmpty() {
        assertTrue(myHashMap.isEmpty());
        myHashMap.put("a","a");
        assertFalse(myHashMap.isEmpty());
    }

    @ParameterizedTest
    @DisplayName("맵에 없는 key로 삽입하면 null을 리턴한다")
    @CsvSource(value = {"b,bee", "b,banana", "c,candy", "d,dragon"}, delimiterString = ",")
    void put(String key, String value) {
        myHashMap.put("a", "aa");
        assertNull(myHashMap.put(key,value));
        assertEquals(2, myHashMap.size());
    }

    @Test
    @DisplayName("맵에 이미 있는 key로 삽입하면 새로운 값으로 replace하고 기존 값을 리턴한다")
    void putDuplicatedKey() {
        myHashMap.put("a", "old-value");
        String returnValue = myHashMap.put("a", "new-value");
        assertEquals("old-value", returnValue);
        assertEquals(1, myHashMap.size());
    }

    @Test
    void remove() {
        myHashMap.put("a", "ably");
        myHashMap.put("a", "awesome");
        myHashMap.remove("a");
        assertTrue(myHashMap.isEmpty());
    }

}