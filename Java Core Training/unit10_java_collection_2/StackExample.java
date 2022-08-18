package com.demo.unit10_java_collection_2;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.push(2);

        while (stack.hasNext()) {
            System.out.println("Data: " + stack.pop());
        }
    }

    static class Stack<T> {
        private ContainerExample.Node<T> current = null;

        public T pop() {
            T result = current.value;
            current = current.next;
            return result;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void push(T value) {
            ContainerExample.Node<T> newNode = new ContainerExample.Node<>(value, current);
            this.current = newNode;
        }
    }
}
