package com.demo.unit10_java_collection_2;

public class ContainerExample {
    public static void main(String[] args) {
        example2();
    }

    public static void example1() {
        Node<String> root = new Node<>("Step 1");
        Node<String> node1 = new Node<>("Step 2");
        Node<String> node2 = new Node<>("Step 3");

        root.next = node1;
        node1.next = node2;
        test(root);
    }

    public static void example2() {
        Node<Integer> root2;

        root2 = new Node<Integer>(99,
                new Node<>(23,
                        new Node<>(11))
        );

        test(root2);
    }

    private static void test(Node<?> node) {
        while (node != null) {
            System.out.println("Value is: " + node.getValue());
            node = node.next;
        }
    }

    static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
