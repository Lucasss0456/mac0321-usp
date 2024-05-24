package ex3;
import java.util.LinkedList;
import java.util.Objects;

public class LinkedListMult<E> {
    private LinkedList<E> list;

    public LinkedListMult() {
        list = new LinkedList<>();
    }

    public void add(E element) {
        list.add(element);
    }

    public boolean remove(E element) {
        return list.remove(element);
    }

    public int count(E element) {
        int count = 0;
        for (E e : list) {
            if (e.equals(element)) {
                count++;
            }
        }
        return count;
    }

    public LinkedList<E> elements() {
        return list;
    }

    public void addAll(LinkedListMult<E> other) {
        list.addAll(other.list);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LinkedListMult<?> other = (LinkedListMult<?>) obj;
        return Objects.equals(list, other.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    public static void main(String[] args) {
        LinkedListMult<String> multi1 = new LinkedListMult<>();
        multi1.add("apple");
        multi1.add("apple");
        multi1.add("banana");

        LinkedListMult<String> multi2 = new LinkedListMult<>();
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
        LinkedListMult<String> multi3 = new LinkedListMult<>();
        multi3.add("apple");
        multi3.add("apple");
        multi3.add("apple");
        multi3.add("banana");
        multi3.add("banana");

        System.out.println("multi1 é igual a multi3? " + multi1.equals(multi3)); // Saída: true
    }
}
