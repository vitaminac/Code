package code.adt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraysTest {
    @Test
    public void binarySearch() {
        assertEquals(-1, Arrays.binarySearch(new Integer[0], 0));
        assertEquals(-1, Arrays.binarySearch(new Integer[0], Integer.MAX_VALUE));
        assertEquals(-1, Arrays.binarySearch(new Integer[0], Integer.MIN_VALUE));
        assertEquals(0, Arrays.binarySearch(java.util.Arrays.stream(new int[]{1, 13, 56, 78, 99}).boxed().toArray(Integer[]::new), 1));
        assertEquals(0, Arrays.binarySearch(java.util.Arrays.stream(new int[]{-1, 13, 56, 78, 99}).boxed().toArray(Integer[]::new), -1));
        assertEquals(0, Arrays.binarySearch(java.util.Arrays.stream(new int[]{0, 13, 56, 78, 99}).boxed().toArray(Integer[]::new), 0));
        assertEquals(0, Arrays.binarySearch(java.util.Arrays.stream(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}).boxed().toArray(Integer[]::new), Integer.MIN_VALUE));
        assertEquals(0, Arrays.binarySearch(java.util.Arrays.stream(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}).boxed().toArray(Integer[]::new), Integer.MAX_VALUE));
    }

    @Test
    public void quicksort() {
        Integer[] arr = {5, 0, 3, 4, 9, 19, 80, 1, 2, 6, 7, 8};
        Arrays.quicksort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int dff = arr[i].compareTo(arr[i + 1]);
            assertTrue(dff < 0);
        }
    }

    @Test
    public void mergesort() {
        Integer[] arr = {5, 0, 3, 4, 9, 1, 2, 6, 7, 8};
        Arrays.mergesort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int dff = arr[i].compareTo(arr[i + 1]);
            assertTrue(dff < 0);
        }
    }
}