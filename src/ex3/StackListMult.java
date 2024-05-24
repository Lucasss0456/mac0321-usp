package ex3;

import java.util.Objects;
import java.util.Stack;

public class StackListMult<E> {
    private Stack<E> stack;

    public StackListMult() {
        stack = new Stack<>();
    }

    public void add(E element) {
        stack.push(element);
    }

    public boolean remove(E element) {
        return stack.remove(element);
    }

    public int count(E element) {
        int count = 0;
        for (E e : stack) {
            if (e.equals(element)) {
                count++;
            }
        }
        return count;
    }

    public Stack<E> elements() {
        return stack;
    }

    public void addAll(StackListMult<E> other) {
        stack.addAll(other.stack);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StackListMult<?> other = (StackListMult<?>) obj;
        return Objects.equals(stack, other.stack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stack);
    }

    public static void main(String[] args) {
        StackListMult<String> multi1 = new StackListMult<>();
        multi1.add("apple");
        multi1.add("apple");
        multi1.add("banana");

        StackListMult<String> multi2 = new StackListMult<>();
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
        StackListMult<String> multi3 = new StackListMult<>();
        multi3.add("apple");
        multi3.add("apple");
        multi3.add("apple");
        multi3.add("banana");
        multi3.add("banana");

        System.out.println("multi1 é igual a multi3? " + multi1.equals(multi3)); // Saída: true
    }
}
