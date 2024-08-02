package structure.data.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    MyQueue<String> queue;
    @BeforeEach
    void setup() {
        queue = new MyQueue<>();
    }

    @Test
    @DisplayName("element() - 큐가 비어있으면 예외 던짐")
    void elementFail() {
        assertThrows(NoSuchElementException.class, () -> queue.element());
    }

    @Test
    void element() {
        queue.add("hello");
        assertEquals("hello", queue.element());
    }

    @Test
    void offer() {
        queue.offer("one");
        queue.offer("two");
        assertEquals(2, queue.size());
    }

    @Test
    void poll() {
        queue.offer("test");
        assertEquals("test", queue.poll());
        assertNull(queue.poll());
    }

    @Test
    void peek() {
        queue.offer("test");
        assertEquals("test", queue.peek());
        assertEquals("test", queue.peek());
        assertEquals("test", queue.peek());
    }
}