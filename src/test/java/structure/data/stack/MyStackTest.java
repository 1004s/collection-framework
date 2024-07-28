package structure.data.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    MyStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new MyStack<>();
        stack.push("white");
        stack.push("red");
        stack.push("green");
        stack.push("blue");
        stack.push("yellow");
    }

    @Test
    void iterator() {
        Iterator<String> iter = stack.iterator();
        StringBuilder builder = new StringBuilder();
        while (iter.hasNext()) {
            builder.append(iter.next()).append("-");
        }
        builder.delete(builder.length()-1, builder.length());

        assertEquals("white-red-green-blue-yellow", builder.toString());
    }


    @Test
    void pop() {
        assertEquals("yellow", stack.pop());
        assertEquals("blue", stack.pop());
        assertEquals("green", stack.pop());
    }

    @Test
    void peek() {
        assertEquals("yellow", stack.peek());
        assertEquals("yellow", stack.peek());
    }

    @Test
    void search() {
        assertEquals(2, stack.search("green"));
        assertEquals(4, stack.search("yellow"));
        assertEquals(-1, stack.search("pink"));
    }

    @Test
    void empty() {
        assertFalse(stack.empty());
        while (!stack.empty()) {
            stack.pop();
        }
        assertTrue(stack.empty());
    }
}