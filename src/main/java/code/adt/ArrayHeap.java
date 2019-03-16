package code.adt;

import java.util.Comparator;
import java.util.Iterator;

public class ArrayHeap<E> implements PriorityQueue<E>, Cloneable {
    private final ArrayList<E> list;
    private final Comparator<E> comparator;

    private ArrayHeap(ArrayList<E> list, Comparator<E> comparator) {
        this.list = list;
        this.comparator = comparator;
    }

    public ArrayHeap(Comparator<E> comparator) {
        this(new ArrayList<>(), comparator);
    }

    public static <E extends Comparable<E>> ArrayHeap<E> create() {
        return new ArrayHeap<>(E::compareTo);
    }

    private void swap(int i, int j) {
        E tmp = this.list.get(i);
        this.list.set(i, this.list.get(j));
        this.list.set(j, tmp);
    }

    @Override
    public void add(E element) {
        int child = this.list.size();
        this.list.add(child, element);
        while (child > 0) {
            int parent = (child - 1) / 2;
            if (this.comparator.compare(this.list.get(child), this.list.get(parent)) < 0) {
                swap(parent, child);
                child = parent;
            } else break;
        }
    }

    @Override
    public E peek() {
        return this.list.get(0);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public E remove() {
        this.swap(0, this.list.size() - 1);
        E retVal = this.list.remove(this.list.size() - 1);
        int parent = 0;
        int left;
        while ((left = parent * 2 + 1) < this.list.size()) {
            int right = parent * 2 + 2;
            if (this.comparator.compare(this.list.get(left), this.list.get(parent)) < 0) {
                swap(parent, left);
                parent = left;
            } else if (right < this.list.size() && this.comparator.compare(this.list.get(right), this.list.get(parent)) < 0) {
                swap(parent, right);
                parent = right;
            } else break;
        }
        return retVal;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private ArrayHeap<E> heap = ArrayHeap.this.clone();

            @Override
            public boolean hasNext() {
                return !this.heap.isEmpty();
            }

            @Override
            public E next() {
                return this.heap.remove();
            }
        };
    }

    @Override
    public ArrayHeap<E> clone() {
        return new ArrayHeap<E>(list.clone(), this.comparator);
    }
}
