package ex4;

import java.util.*;

import ex3.StackListMult;

public class StackMultToSetAdapter<E> implements Set<E> {
    private StackListMult<E> multiset;

    public StackMultToSetAdapter(StackListMult<E> multiset) {
        this.multiset = multiset;
    }

    @Override
    public int size() {
        return new HashSet<>(multiset.elements()).size();
    }

    @Override
    public boolean isEmpty() {
        return multiset.elements().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return multiset.count((E) o) > 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MultiSetIterator();
    }

    @Override
    public Object[] toArray() {
        return new HashSet<>(multiset.elements()).toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return new HashSet<>(multiset.elements()).toArray(a);
    }

    @Override
    public boolean add(E e) {
        multiset.add(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return multiset.remove((E) o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            multiset.add(e);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (Iterator<E> iterator = multiset.elements().iterator(); iterator.hasNext();) {
            E element = iterator.next();
            if (!c.contains(element)) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object o : c) {
            modified |= remove(o);
        }
        return modified;
    }

    @Override
    public void clear() {
        multiset = new StackListMult<>();
    }

    // Iterator implementation for the adapter
    private class MultiSetIterator implements Iterator<E> {
        private final Iterator<E> it;
        private E currentElement;
        private int remaining;

        public MultiSetIterator() {
            it = new HashSet<>(multiset.elements()).iterator();
            if (it.hasNext()) {
                currentElement = it.next();
                remaining = multiset.count(currentElement);
            } else {
                currentElement = null;
                remaining = 0;
            }
        }

        @Override
        public boolean hasNext() {
            return remaining > 0 || it.hasNext();
        }

        @Override
        public E next() {
            if (remaining <= 0) {
                currentElement = it.next();
                remaining = multiset.count(currentElement);
            }
            remaining--;
            return currentElement;
        }
    }

    @Override
    public String toString() {
        return multiset.elements().toString();
    }
    
    public static void main(String[] args) {
        StackListMult<String> multiset = new StackListMult<>();
        multiset.add("apple");
        multiset.add("apple");
        multiset.add("banana");

        Set<String> set = new StackMultToSetAdapter<>(multiset);

        System.out.println("Set contains \"apple\": " + set.contains("apple")); // Saída: true
        System.out.println("Set contains \"pear\": " + set.contains("pear")); // Saída: false

        System.out.println("Iterating over set:");
        for (String element : set) {
            System.out.println(element);
        }

        System.out.println("Set size: " + set.size()); // Saída: 2

        set.remove("apple");
        System.out.println("After removing \"apple\": " + set); // Saída: [banana]
    }
}

