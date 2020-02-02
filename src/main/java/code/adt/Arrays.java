package code.adt;

import java.util.Comparator;

public class Arrays {
    @SuppressWarnings("unchecked")
    public static <E> E[] copyFrom(E[] arr, int from, int length) {
        E[] clone = (E[]) new Object[length];
        for (int i = from + length - 1; i >= from; i--) clone[i] = arr[i];
        return clone;
    }

    public static <E> void fill(E[] arr, E value) {
        for (int i = 0; i < arr.length; i++) arr[i] = value;
    }

    /**
     * Returns the left-most index of the specified key in a sorted array.
     *
     * @param arr
     * @param key
     * @return the position of key, negative number if not found
     */
    public static <E> int binarySearch(E[] arr, E key, int low, int high, Comparator<? super E> comparator) {
        int diff = -1;
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            diff = comparator.compare(key, arr[mid]);
            if (diff <= 0) high = mid - 1;
            else low = mid + 1;
        }
        if (diff == 0) return low; // key found
        else return -low - 1;  // key not found
    }

    public static <E> int binarySearch(E[] arr, E key, Comparator<? super E> comparator) {
        return binarySearch(arr, key, 0, arr.length - 1, comparator);
    }

    public static <E extends Comparable<? super E>> int binarySearch(E[] arr, E key, int low, int high) {
        return binarySearch(arr, key, low, high, E::compareTo);
    }

    public static <E extends Comparable<? super E>> int binarySearch(E[] arr, E key) {
        return binarySearch(arr, key, E::compareTo);
    }

    public static <E> void quicksort(E[] arr, int low, int high, Comparator<? super E> comparator) {
        if (low >= high) return;
        int left = low;
        int right = high - 1;
        E pivot = arr[high];
        while (right >= left) {
            if (comparator.compare(arr[left], pivot) <= 0) left += 1;
            else {
                E tmp = arr[left];
                arr[left] = arr[right];
                arr[right--] = tmp;
            }
        }
        arr[high] = arr[left];
        arr[left] = pivot;
        quicksort(arr, low, right, comparator);
        quicksort(arr, left, high, comparator);
    }

    public static <E> void quicksort(E[] arr, Comparator<? super E> comparator) {
        quicksort(arr, 0, arr.length - 1, comparator);
    }

    public static <E extends Comparable<? super E>> void quicksort(E[] arr, int low, int high) {
        quicksort(arr, low, high, E::compareTo);
    }

    public static <E extends Comparable<? super E>> void quicksort(E[] arr) {
        quicksort(arr, E::compareTo);
    }
}
