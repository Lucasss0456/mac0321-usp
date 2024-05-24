package ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

public class LinkedListMultTest {

    private LinkedListMult<String> linkedListMult;

    @BeforeEach
    public void setUp() {
        linkedListMult = new LinkedListMult<>();
    }

    @Test
    public void testAdd() {
        linkedListMult.add("apple");
        linkedListMult.add("banana");
        linkedListMult.add("apple");
        assertEquals(2, linkedListMult.count("apple"));
        assertEquals(1, linkedListMult.count("banana"));
    }

    @Test
    public void testRemove() {
        linkedListMult.add("apple");
        linkedListMult.add("banana");
        linkedListMult.add("apple");
        assertTrue(linkedListMult.remove("apple"));
        assertEquals(1, linkedListMult.count("apple"));
        assertTrue(linkedListMult.remove("apple"));
        assertEquals(0, linkedListMult.count("apple"));
        assertFalse(linkedListMult.remove("pear"));
    }

    @Test
    public void testCount() {
        linkedListMult.add("apple");
        linkedListMult.add("banana");
        linkedListMult.add("apple");
        assertEquals(2, linkedListMult.count("apple"));
        assertEquals(1, linkedListMult.count("banana"));
        assertEquals(0, linkedListMult.count("pear"));
    }

    @Test
    public void testElements() {
        linkedListMult.add("apple");
        linkedListMult.add("banana");
        linkedListMult.add("apple");
        LinkedList<String> elements = linkedListMult.elements();
        assertEquals(3, elements.size());
        assertTrue(elements.contains("apple"));
        assertTrue(elements.contains("banana"));
    }

    @Test
    public void testAddAll() {
        LinkedListMult<String> other = new LinkedListMult<>();
        other.add("apple");
        other.add("pear");
        other.add("apple");

        linkedListMult.add("banana");
        linkedListMult.addAll(other);

        assertEquals(2, linkedListMult.count("apple"));
        assertEquals(1, linkedListMult.count("banana"));
        assertEquals(1, linkedListMult.count("pear"));
    }

}
