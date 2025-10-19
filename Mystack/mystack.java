import java.util.Arrays;
import java.util.EmptyStackException;

public class mystack<E> {
    private static final int DEFAULT_SIZE = 3;
    private E[] elements;
    private int top;

    public mystack() {
        this(DEFAULT_SIZE);
    }

    public mystack(int initialCapacity) {
        elements = (E[]) new Object[initialCapacity];
        top = 0;
    }

    public void push(E item) {
        if (top == elements.length) {
            expandCapacity();
        }
        elements[top++] = item;
    }

    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();

        E removed = elements[--top];
        elements[top] = null;
        return removed;
    }

    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return elements[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int size() {
        return top;
    }

    public String show() {
        if (isEmpty()) {
            return "Stack is empty!";
        }
        StringBuilder sb = new StringBuilder("Stack elements (bottom → top): ");
        for (int i = 0; i < top; i++) {
            sb.append(elements[i]);
            if (i < top - 1) sb.append(", ");
        }
        return sb.toString();
    }

    private void expandCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public static void main(String[] args) {
        mystack<String> s = new mystack<>(2);
        s.push("Hani");
        s.push("Jamhuuriya");
        s.push("Mogadishu");

        System.out.println(s.show());
        System.out.println("Top element: " + s.peek());
        System.out.println("Size: " + s.size());

        s.pop();
        System.out.println("After pop: " + s.show());
    }
}

