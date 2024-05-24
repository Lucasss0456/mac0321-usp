package ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMultiTest {

    private ArrayListMulti<String> arrayListMulti;

    @BeforeEach
    public void setUp() {
        arrayListMulti = new ArrayListMulti<>();
    }

    @Test
    public void testAdd() {
        arrayListMulti.add("apple");
        arrayListMulti.add("banana");
        arrayListMulti.add("apple");
        assertEquals(2, arrayListMulti.count("apple"));
        assertEquals(1, arrayListMulti.count("banana"));
    }

    @Test
    public void testRemove() {
        arrayListMulti.add("apple");
        arrayListMulti.add("banana");
        arrayListMulti.add("apple");
        assertTrue(arrayListMulti.remove("apple"));
        assertEquals(1, arrayListMulti.count("apple"));
        assertTrue(arrayListMulti.remove("apple"));
        assertEquals(0, arrayListMulti.count("apple"));
        assertFalse(arrayListMulti.remove("pear"));
    }

    @Test
    public void testCount() {
        arrayListMulti.add("apple");
        arrayListMulti.add("banana");
        arrayListMulti.add("apple");
        assertEquals(2, arrayListMulti.count("apple"));
        assertEquals(1, arrayListMulti.count("banana"));
        assertEquals(0, arrayListMulti.count("pear"));
    }

    @Test
    public void testElements() {
        arrayListMulti.add("apple");
        arrayListMulti.add("banana");
        arrayListMulti.add("apple");
        List<String> elements = arrayListMulti.elements();
        assertEquals(3, elements.size());
        assertTrue(elements.contains("apple"));
        assertTrue(elements.contains("banana"));
    }

    @Test
    public void testAddAll() {
        ArrayListMulti<String> other = new ArrayListMulti<>();
        other.add("apple");
        other.add("pear");
        other.add("apple");
        
        arrayListMulti.add("banana");
        arrayListMulti.addAll(other);

        assertEquals(2, arrayListMulti.count("apple"));
        assertEquals(1, arrayListMulti.count("banana"));
        assertEquals(1, arrayListMulti.count("pear"));
    }

    @Test
    public void testEqualsAndHashCode() {
        ArrayListMulti<String> other1 = new ArrayListMulti<>();
        ArrayListMulti<String> other2 = new ArrayListMulti<>();

        other1.add("apple");
        other1.add("banana");

        other2.add("apple");
        other2.add("banana");

        assertTrue(arrayListMulti.equals(arrayListMulti)); // reflexive
        assertFalse(arrayListMulti.equals(null)); // null check
        assertFalse(arrayListMulti.equals(other2)); // content check
    }
}
