package core.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedListDoubleReference<E> implements Steque<E> {
    private static class LinkedNode<E> {
        private final E element;
        private LinkedNode<E> next;

        private LinkedNode(E element) {
            this.element = element;
        }
    }

    private LinkedNode<E> head;
    private LinkedNode<E> tail;

    public SinglyLinkedListDoubleReference() {
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public int size() {
        int n = 0;
        var current = this.head;
        while (current != null) {
            current = current.next;
            n += 1;
        }
        return n;
    }

    @Override
    public E peek() {
        return this.head.element;
    }

    @Override
    public void push(E element) {
        final var node = new LinkedNode<E>(element);
        if (this.isEmpty()) {
            this.tail = node;
        } else {
            node.next = this.head;
        }
        this.head = node;
    }

    @Override
    public void append(E element) {
        final var node = new LinkedNode<E>(element);
        if (this.isEmpty()) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
    }

    @Override
    public E pop() {
        if (this.isEmpty()) throw new NoSuchElementException();
        final var result = this.head.element;
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private LinkedNode<E> next = SinglyLinkedListDoubleReference.this.head;

            @Override
            public boolean hasNext() {
                return this.next != null;
            }

            @Override
            public E next() {
                if (this.next == null) throw new NoSuchElementException();
                final var item = this.next.element;
                this.next = this.next.next;
                return item;
            }
        };
    }
}
