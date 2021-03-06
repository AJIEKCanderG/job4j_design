package ru.job4j.collection;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        } else {
            Node<T> tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }
    }

    public void addFirst(T value) {
        Node<T> node = new Node<>(value, null);
        node.next = head;
        head = node;

    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T currentFirst = head.value;
        head = head.next;
        return currentFirst;
    }

    public boolean revert() {
          if (head == null || head.next == null) {
            return false;
         }
            Node<T> node = null;
            Node<T> nodeNext = head;
           while (nodeNext != null)  {
                Node<T> next = nodeNext.next;
                nodeNext.next = node;
                node = nodeNext;
                nodeNext = next;

            }
        head = node;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }


    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}