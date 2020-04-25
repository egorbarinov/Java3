package Lesson_6.hw;

//2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной
// четверки или единицы, то метод вернет false; Написать набор тестов для этого метода
// (по 3-4 варианта входных данных).

public class MyBoolean {
    public boolean bool (int[] arr) {
        boolean b = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                b = true;
            } else {
                if (arr[i] == 4) {
                    b = true;
                } else {
                    b = false;
                    break;
                }
            }
        }return b;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 1, 4, 1, 4, 4, 4}; // true
        int[] arr2 = {1, 4, 1, 1, 4, 1, 3, 4, 4}; // false
        MyBoolean mb = new MyBoolean();
        System.out.println(mb.bool(arr));
        System.out.println(mb.bool(arr2));
    }
}
