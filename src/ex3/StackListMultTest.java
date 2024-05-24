package ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

public class StackListMultTest {

    private StackListMult<String> stackListMult;

    @BeforeEach
    public void setUp() {
        stackListMult = new StackListMult<>();
    }

    @Test
    public void testAdd() {
        stackListMult.add("apple");
        stackListMult.add("banana");
        stackListMult.add("apple");
        assertEquals(2, stackListMult.count("apple"));
        assertEquals(1, stackListMult.count("banana"));
    }

    @Test
    public void testRemove() {
        stackListMult.add("apple");
        stackListMult.add("banana");
        stackListMult.add("apple");
        assertTrue(stackListMult.remove("apple"));
        assertEquals(1, stackListMult.count("apple"));
        assertTrue(stackListMult.remove("apple"));
        assertEquals(0, stackListMult.count("apple"));
        assertFalse(stackListMult.remove("pear"));
    }

    @Test
    public void testCount() {
        stackListMult.add("apple");
        stackListMult.add("banana");
        stackListMult.add("apple");
        assertEquals(2, stackListMult.count("apple"));
        assertEquals(1, stackListMult.count("banana"));
        assertEquals(0, stackListMult.count("pear"));
    }

    @Test
    public void testElements() {
        stackListMult.add("apple");
        stackListMult.add("banana");
        stackListMult.add("apple");
        Stack<String> elements = stackListMult.elements();
        assertEquals(3, elements.size());
        assertTrue(elements.contains("apple"));
        assertTrue(elements.contains("banana"));
    }

    @Test
    public void testAddAll() {
        StackListMult<String> other = new StackListMult<>();
        other.add("apple");
        other.add("pear");
        other.add("apple");

        stackListMult.add("banana");
        stackListMult.addAll(other);

        assertEquals(2, stackListMult.count("apple"));
        assertEquals(1, stackListMult.count("banana"));
        assertEquals(1, stackListMult.count("pear"));
    }

    
}
