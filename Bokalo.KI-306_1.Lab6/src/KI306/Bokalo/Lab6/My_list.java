package KI306.Bokalo.Lab6;

/**
 * Тут реалізовано клас My_list
 * @author Petro Bokalo KI-306
 * @version 1.0
 * @since version 1.0
*/

public class My_list<T extends Comparable<T>> {
    private Node<T> head;

    public My_list() {
        this.head = null;
    }
    
    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Додавання елементу в кінець списку
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Видалення елементу за значенням
    public void remove(T data) {
        if (head == null) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Пошук мінімального елемента
    public T findMin() {
        if (head == null) {
            return null;
        }
        T min = head.data;
        Node<T> current = head;
        while (current != null) {
            if (current.data.compareTo(min) < 0) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    // Виведення всього списку
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}