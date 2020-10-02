package core;

import java.util.function.Consumer;

public interface Queue<E> extends Enumerable<E> {
    int size();

    boolean isEmpty();

    E peek();

    void enqueue(E element);

    E dequeue();

    static <E> Queue<E> fromDeque(final Deque<E> deque) {
        return new Queue<E>() {
            @Override
            public int size() {
                return deque.size();
            }

            @Override
            public boolean isEmpty() {
                return deque.isEmpty();
            }

            @Override
            public E peek() {
                return deque.first();
            }

            @Override
            public void enqueue(E element) {
                deque.addLast(element);
            }

            @Override
            public E dequeue() {
                return deque.removeFirst();
            }

            @Override
            public void forEach(Consumer<? super E> consumer) {
                deque.forEach(consumer);
            }
        };
    }
}