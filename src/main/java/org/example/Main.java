package org.example;


/*
Написать скрипт для расчета корреляции Пирсона между
двумя случайными величинами (двумя массивами). Можете
использовать любую парадигму, но рекомендую использовать
функциональную, т.к. в этом примере она значительно
упростит вам жизнь.
 */
public class Main {
    public static void main(String[] args) {

        int[] array1 = {2, 3, 4, 5, 6};
        int[] array2 = {2, 3, 5, 10, 7};

        double pirson = correlation(array1, array2);

        System.out.println(pirson);

    }

    public static double correlation(int[] arrayX, int[] arrayY) {
        if (arrayX.length != arrayY.length) {
            throw new RuntimeException("Массивы должны быть одинаковой длины!");
        }

        int length = arrayX.length;

        double averageX = average(arrayX);
        double averageY = average(arrayY);

        double numerator = 0;
        double denominatorX = 0;
        double denominatorY = 0;
        for (int i = 0; i < length; i++) {
            numerator += (arrayX[i] - averageX) * (arrayY[i] - averageY);
            denominatorX += Math.pow(arrayX[i] - averageX, 2);
            denominatorY += Math.pow(arrayY[i] - averageY, 2);
        }
        denominatorX = Math.sqrt(denominatorX);
        denominatorY = Math.sqrt(denominatorY);

        return numerator / (denominatorX * denominatorY);
    }

    private static double average(int[] array) {
        return sum(array) / array.length;
    }

    private static double sum(int[] array) {
        int result = 0;
        for (int i : array) {
            result += i;
        }
        return result;
    }
}
