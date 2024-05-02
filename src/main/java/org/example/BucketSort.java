package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    // карманная сортировка
    //принцип работы: делим массив на карманы их количество зависит от диапазона чисел
    //далее сортируем карманы и отправляем их в исходный массив
    public void bucketSort(int[] array) {
        int n = array.length;
        if (n <= 0) return;

        // находим минимум и максимум в массиве
        int minVal = array[0];
        int maxVal = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] < minVal) minVal = array[i];
            else if (array[i] > maxVal) maxVal = array[i];
        }

        // создаем карманы
        int bucketCount = (maxVal - minVal) / n + 1; // определяем количество карманов
        List<List<Integer>> buckets = new ArrayList<>(bucketCount); // создаем список карманов
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>()); // инициализируем каждый карман пустым списком
        }

        // распределяем элементы по карманам
        for (int i = 0; i < n; i++) {
            int bucketIndex = (array[i] - minVal) / n; // вычисляем индекс кармана для текущего элемента
            buckets.get(bucketIndex).add(array[i]); // добавляем элемент в соответствующий карман
        }

        // сортируем каждый карман и объединяем их
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            Collections.sort(buckets.get(i)); // сортируем текущий карман
            for (int j = 0; j < buckets.get(i).size(); j++) {
                array[index++] = buckets.get(i).get(j); // добавляем отсортированные элементы из кармана в исходный массив
            }
        }
    }
}
