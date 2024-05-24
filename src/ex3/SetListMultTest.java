package ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class SetListMultTest {

    private SetListMult<String> setListMult;

    @BeforeEach
    public void setUp() {
        setListMult = new SetListMult<>();
    }

    @Test
    public void testAdd() {
        setListMult.add("apple");
        setListMult.add("banana");
        setListMult.add("apple");
        assertEquals(2, setListMult.count("apple"));
        assertEquals(1, setListMult.count("banana"));
    }

    @Test
    public void testRemove() {
        setListMult.add("apple");
        setListMult.add("banana");
        setListMult.add("apple");
        assertTrue(setListMult.remove("apple"));
        assertEquals(1, setListMult.count("apple"));
        assertTrue(setListMult.remove("apple"));
        assertEquals(0, setListMult.count("apple"));
        assertFalse(setListMult.remove("pear"));
    }

    @Test
    public void testCount() {
        setListMult.add("apple");
        setListMult.add("banana");
        setListMult.add("apple");
        assertEquals(2, setListMult.count("apple"));
        assertEquals(1, setListMult.count("banana"));
        assertEquals(0, setListMult.count("pear"));
    }

    @Test
    public void testElements() {
        setListMult.add("apple");
        setListMult.add("banana");
        setListMult.add("apple");
        Set<String> elements = setListMult.elements();
        assertEquals(2, elements.size()); // Note que isso retorna o conjunto subjacente, que não tem duplicatas
        assertTrue(elements.contains("apple"));
        assertTrue(elements.contains("banana"));
    }

    @Test
    public void testAddAll() {
        SetListMult<String> other = new SetListMult<>();
        other.add("apple");
        other.add("pear");
        other.add("apple");

        setListMult.add("banana");
        setListMult.addAll(other);

        assertEquals(2, setListMult.count("apple"));
        assertEquals(1, setListMult.count("banana"));
        assertEquals(1, setListMult.count("pear"));
    }

}
