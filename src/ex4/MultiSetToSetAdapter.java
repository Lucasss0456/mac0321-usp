package ex4;

import java.util.*;

import ex3.ArrayListMulti;

public class MultiSetToSetAdapter<E> implements Set<E> {
    private ArrayListMulti<E> multiSet;

    public MultiSetToSetAdapter(ArrayListMulti<E> multiSet) {
        this.multiSet = multiSet;
    }

    @Override
    public int size() {
        return multiSet.elements().size();
    }

    @Override
    public boolean isEmpty() {
        return multiSet.elements().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return multiSet.count((E) o) > 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MultiSetIterator();
    }

    @Override
    public Object[] toArray() {
        return multiSet.elements().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return multiSet.elements().toArray(a);
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException("Cannot directly add to adapter");
    }

    @Override
    public boolean remove(Object o) {
        return multiSet.remove((E) o);
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
        throw new UnsupportedOperationException("Cannot directly add to adapter");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (Iterator<E> iterator = multiSet.elements().iterator(); iterator.hasNext();) {
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
        multiSet = new ArrayListMulti<>();
    }

    // Iterator implementation for the adapter
    private class MultiSetIterator implements Iterator<E> {
        private final Iterator<E> it;
        private E currentElement;
        private int remaining;

        public MultiSetIterator() {
            it = multiSet.elements().iterator();
            if (it.hasNext()) {
                currentElement = it.next();
                remaining = multiSet.count(currentElement);
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
                remaining = multiSet.count(currentElement);
            }
            remaining--;
            return currentElement;
        }
    }
    public static void main(String[] args) {
        ArrayListMulti<String> multiSet = new ArrayListMulti<>();
        multiSet.add("apple");
        multiSet.add("apple");
        multiSet.add("banana");

        Set<String> set = new MultiSetToSetAdapter<>(multiSet);

        System.out.println("Set contains \"apple\": " + set.contains("apple")); // Saída: true
        System.out.println("Set contains \"pear\": " + set.contains("pear")); // Saída: false

        System.out.println("Iterating over set:");
        for (String element : set) {
            System.out.println(element);
        }

        System.out.println("Set size: " + set.size()); // Saída: 2

        set.remove("apple");
        //System.out.println("After removing \"apple\": " + set); // Saída: [apple, banana]
    }
}


