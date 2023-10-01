package org.example;

/*
Написать программу на любом языке в любой парадигме для
бинарного поиска. На вход подаётся целочисленный массив и
число. На выходе - индекс элемента или -1, в случае если искомого
элемента нет в массиве.
 */
public class Main {

    public static void main(String[] args) {
        int[] values = {1, 1, 1, 2, 3, 4, 10};
        int valueToFind = 10;

        System.out.printf("Index = %d%n", binarySearch(values, valueToFind));
        System.out.printf("Index = %d%n", binarySearch(values, valueToFind, 0, values.length - 1));
    }

    // Без рекурсии
    private static int binarySearch(int[] sortedArray, int valueToFind) {
        int index = -1;
        int low = 0;
        int length = sortedArray.length;

        while (low <= length - 1) {
            int mid = low + (length - low) / 2;
            if (sortedArray[mid] < valueToFind) {
                low = mid + 1;
            } else if (sortedArray[mid] > valueToFind) {
                length = mid - 1;
            } else if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            }
        }
        return index;
    }

    // С рекурсией
    private static int binarySearch(int[] values, int valueToFind, int start, int range) {
        if (start == range) {
            return (values[start] == valueToFind) ? start : -1;
        }

        int mid = start + (range - start) / 2;

        if (valueToFind > values[mid]) {
            return binarySearch(values, valueToFind, mid + 1, range);
        } else if (values[mid] > valueToFind) {
            return binarySearch(values, valueToFind, start, mid - 1);
        }
        return mid;
    }

}
