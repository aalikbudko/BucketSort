import static org.junit.jupiter.api.Assertions.*;

import org.example.BucketSort;
import org.junit.jupiter.api.Test;

class BucketSortTest {

    @Test
    void testNegativeNumbers() {
        BucketSort BucketSort = new BucketSort();
        int[] array = { -5, -1, -3, -2, -4 };
        int[] expected = { -5, -4, -3, -2, -1 };
        BucketSort.bucketSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testDuplicateNumbers() {
        BucketSort BucketSort = new BucketSort();
        int[] array = { 3, 1, 2, 3, 1 };
        int[] expected = { 1, 1, 2, 3, 3 };
        BucketSort.bucketSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testEmptyArray() {
        BucketSort BucketSort = new BucketSort();
        int[] array = {};
        int[] expected = {};
        BucketSort.bucketSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testSingleElementArray() {
        BucketSort BucketSort = new BucketSort();
        int[] array = { 42 };
        int[] expected = { 42 };
        BucketSort.bucketSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMaxAndMinIntegers() {
        BucketSort BucketSort = new BucketSort();
        int[] array = { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        int[] expected = { Integer.MIN_VALUE, 0, Integer.MAX_VALUE };
        BucketSort.bucketSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testOutOfMemory() {
        BucketSort BucketSort = new BucketSort();
        int[] array = new int[0];
        int count = 0;
        boolean outOfMemoryOccurred = false;

        try {
            while (count <= Integer.MAX_VALUE / 2) {
                array = new int[count];
                for (int i = 0; i < count; i++) {
                    array[i] = i;
                }
                BucketSort.bucketSort(array);
                count*=2;
            }
        } catch (OutOfMemoryError e) {
            outOfMemoryOccurred = true;
            System.out.println("Out of memory at array length: " + count);
        }

        assertTrue(outOfMemoryOccurred, "Test should result in OutOfMemoryError");
    }
}
