package org.example;

public class Main {
    public static void main(String[] args) {
        // исходный массив
        int[] array = {29, 25, 3, 49, 9, 37, 21, 43};

        // вывод исходного массива
        System.out.println("source array:");
        printArray(array);
        BucketSort sorter = new BucketSort();
        //сортируем массив
        sorter.bucketSort(array);
        // вывод отсортированного массива
        System.out.println("sorted array:");
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
