package org.example;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
        Задача №1
        Дан список целых чисел numbers. Необходимо написать в императивном стиле процедуру для
        сортировки числа ворядке убывания. Можно использовать любой алгоритм сортировки.
         */
        List<Integer> numbers1 = Arrays.asList(6, 1, 5, 7, 8, 2, 9, 3, 10, 4);
        sortListDescending(numbers1);
        System.out.println(numbers1);


        /*
        Задача №2
        Написать точно такую же процедуру, но в декларативном стиле
        */
        List<Integer> numbers2 = Arrays.asList(6, 1, 5, 7, 8, 2, 9, 3, 10, 4);
        numbers2.sort(Collections.reverseOrder());
        System.out.println(numbers2);


        /*
        Задача- 3: У вас есть массив целых чисел, в котором каждое число,
        кроме одного, повторяется дважды. Вам нужно найти это одиночное число.
        __
        Пример:
        __
        Входной массив: [4, 3, 2, 4, 1, 3, 2]
        Результат: 1
        В данной задаче вы должны найти способ найти одиночное число с использованием массивов и алгоритмов.
         */

        int[] arr1 = {4, 3, 2, 4, 1, 3, 2};
        boolean find1 = false;
        for (int i = 0; i < arr1.length; i++) {
            int result = arr1[i];
            for (int j = 0; j < arr1.length; j++) {
                if (j == i) {
                    continue;
                }
                if (result == arr1[j]) {
                    find1 = true;
                    break;
                }
            }
            if (!find1) {
                System.out.printf("Результат: %d%n", result);
                break;
            }
            find1 = false;
        }


        /*
        Задача-4: У вас есть массив, содержащий числа от 1 до N, где N - длина массива.
        Одно из чисел в массиве повторяется дважды, а одно число пропущено.
        Найдите повторяющееся число и пропущенное число.
        __
        Пример:
        __

        Входной массив: [2, 3, 1, 5, 3]
        Повторяющееся число: 3
        Пропущенное число: 4
         */

        int[] arr2 = {2, 3, 1, 5, 3};
        int length = arr2.length;
        int count = 0;
        int duplicate = 0;
        int miss = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int k : arr2) {
                if (length == k) {
                    count++;
                }
            }
            if (count == 0) {
                miss = length;
            }
            if (count > 1) {
                duplicate = length;
            }
            length--;
            count = 0;
        }
        System.out.printf("Повторяющееся число: %d%n", duplicate);
        System.out.printf("Пропущенное число: %d%n", miss);
    }

    public static void sortListDescending(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j + 1) > list.get(j)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

}