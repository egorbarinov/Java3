package Lesson_6.hw;

import java.util.Arrays;

//1. Написать метод, которому в качестве аргумента передается не пустой одномерный
// целочисленный массив. Метод должен вернуть новый массив, который получен путем
// вытаскивания из исходного массива элементов, идущих после последней четверки.
// Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо
// выбросить RuntimeException. Написать набор тестов для этого метода
// (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

public class ArrFoundFour {

    public int[] arrFoundFour(int[] arr) throws RuntimeException {
        //int[] arr = {1,2,4,4,2,3,4,1,7}; // 4 с конца это 6 элемент массива
        int[] newArr = null;
        int j = 0;
        boolean found = false;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                j = i; // j= 6
                found = true;
                break;
            }
        }
        if (found) {
            newArr = new int[arr.length - j - 1]; // 9-6-1=2
            System.arraycopy(arr, j + 1, newArr, 0, arr.length - j - 1);
        } else {
            throw new RuntimeException("Значение массива равное 4 отсутствует");
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,4,2,3,4,1,7};
        ArrFoundFour aff = new ArrFoundFour();
        System.out.println(Arrays.toString(aff.arrFoundFour(arr))); // [1, 7]
    }
}
