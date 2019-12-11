package code.adt;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public interface Enumerable<E> extends Iterable<E> {
    void enumerate(Consumer<E> consumer);

    default Enumerable<E> map(UnaryOperator<E> operator) {
        return consumer -> this.enumerate(e -> consumer.accept(operator.apply(e)));
    }

    @SuppressWarnings("unchecked")
    default <R> R reduce(R identity, BiFunction<E, R, R> accumulator) {
        R[] ref = (R[]) new Object[]{identity};
        this.enumerate(e -> ref[0] = accumulator.apply(e, ref[0]));
        return ref[0];
    }

    default Enumerable<E> filter(Predicate<E> predicate) {
        return consumer -> this.enumerate(e -> {
            if (predicate.test(e)) {
                consumer.accept(e);
            }
        });
    }

    @Override
    default Iterator<E> iterator() {
        Queue<E> queue = new LinkedList<>();
        this.enumerate(queue::enqueue);
        return queue.iterator();
    }
}
