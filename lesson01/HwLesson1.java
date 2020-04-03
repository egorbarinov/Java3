package Lesson_1.hw;

import com.sun.scenario.animation.shared.ClipEnvelope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HwLesson1 {
    public static void main(String[] args) {
        // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        String[] str = {"раз", "два", "три", "четыре", "пять"};
        changeString(str);
        System.out.println(Arrays.toString(str)); // [пять, два, три, четыре, раз]

        // 2. Написать метод, который преобразует массив в ArrayList;
        System.out.println("Это преобразованный массив стрингов в ArrayList: " + arrList(str)); // [пять, два, три, четыре, раз]

        // 3. Большая задача:
        Apple apple = new Apple();
        Orange orange = new Orange();
        Box<Apple> box0 = new Box<>();
        Box<Orange> box1 = new Box<>();
        Box<Orange> box2 = new Box<>();
        Box<Orange> box3 = new Box<>();

        // наполним коробки фруктами
        for (int i = 0; i < 12; i++) {
            box0.addFruit(apple);
        }
        System.out.println("Вес коробки с яблоками: " + box0.getWeightBoxFruits()); // Вес коробки с яблоками: 10.0

        for (int i = 0; i < 5; i++) {
            box1.addFruit(orange);
        }
        System.out.println("Вес первой коробки с апельсинами: " + box1.getWeightBoxFruits()); // Вес первой коробки с апельсинами: 15.0

        for (int i = 0; i < 8; i++) {
            box2.addFruit(orange);
        }
        System.out.println("Вес второй коробки с апельсинами: " + box2.getWeightBoxFruits()); // Вес второй коробки с апельсинами: 7.5

        // Сравним коробки по весу
        System.out.println(box0.compare(box1)); //false
        System.out.println(box0.compare(box2)); // true

        // пересыпим фрукты из одной коробки в другую
        box1.movingFruitFromBoxToBox(box3);
        box2.movingFruitFromBoxToBox(box3);
        System.out.println("Первая коробка c апельсинами теперь пустая: " + box1.getWeightBoxFruits()); // 0.0
        System.out.println("Вторая коробка c апельсинами тоже теперь пустая: " + box2.getWeightBoxFruits()); // 0.0
        System.out.println("Вес новой коробки с пересыпанными апельсинами составил: " + box3.getWeightBoxFruits()); // 19.5

    }

    // 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static String[] changeString(String[] str){
        String s;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == str[0]){
                s = str[i];
                str[0] = str[str.length - 1];
                str[str.length - 1] = s;
            }
        }
        return str;
    }

    // 2. Написать метод, который преобразует массив в ArrayList;
    public static List<String> arrList(String[] s) {
        return new ArrayList<>(Arrays.asList(s));
    }
}
