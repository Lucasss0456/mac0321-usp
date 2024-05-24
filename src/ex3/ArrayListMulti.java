package ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ArrayListMulti<E> {
    private Map<E, Integer> map;

    public ArrayListMulti() {
        map = new HashMap<>();
    }

    public void add(E element) {
        map.put(element, map.getOrDefault(element, 0) + 1);
    }

    public boolean remove(E element) {
        if (!map.containsKey(element)) {
            return false;
        }
        int count = map.get(element);
        if (count > 1) {
            map.put(element, count - 1);
        } else {
            map.remove(element);
        }
        return true;
    }

    public int count(E element) {
        return map.getOrDefault(element, 0);
    }

    public List<E> elements() {
        List<E> elements = new ArrayList<>();
        for (Map.Entry<E, Integer> entry : map.entrySet()) {
            E element = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                elements.add(element);
            }
        }
        return elements;
    }

    public void addAll(ArrayListMulti<E> other) {
        for (Map.Entry<E, Integer> entry : other.map.entrySet()) {
            E element = entry.getKey();
            int count = entry.getValue();
            map.put(element, map.getOrDefault(element, 0) + count);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArrayListMulti<?> other = (ArrayListMulti<?>) obj;
        return Objects.equals(map, other.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }

    public static void main(String[] args) {
        ArrayListMulti<String> multi1 = new ArrayListMulti<>();
        multi1.add("apple");
        multi1.add("apple");
        multi1.add("banana");

        ArrayListMulti<String> multi2 = new ArrayListMulti<>();
        multi2.add("apple");
        multi2.add("banana");

        // Adicionando todos os elementos de multi2 em multi1
        multi1.addAll(multi2);

        // Verificando a contagem dos elementos
        System.out.println("Contagem de maçãs em multi1: " + multi1.count("apple")); // Saída: 3
        System.out.println("Contagem de bananas em multi1: " + multi1.count("banana")); // Saída: 2

        // Comparando os dois multiconjuntos
        System.out.println("multi1 é igual a multi2? " + multi1.equals(multi2)); // Saída: false

        // Criando um terceiro multiconjunto igual a multi1 para testar equals
        ArrayListMulti<String> multi3 = new ArrayListMulti<>();
        multi3.add("apple");
        multi3.add("apple");
        multi3.add("apple");
        multi3.add("banana");
        multi3.add("banana");

        System.out.println("multi1 é igual a multi3? " + multi1.equals(multi3)); // Saída: true
    }
}
