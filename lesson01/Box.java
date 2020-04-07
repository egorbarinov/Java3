package Lesson_1.hw;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    //c. Для хранения фруктов внутри коробки можете использовать ArrayList;

    private List<T> boxFruits;

    public Box() {
        boxFruits = new ArrayList<T>();
    }

    //g. Не забываем про метод добавления фрукта в коробку.

    public void addFruit(T fruits) {
        boxFruits.add(fruits);
    }

    //d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов
    // и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);

    public float getWeightBoxFruits() {
        float sum = 0;
        for (T fruit:
                boxFruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    // e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
    // которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае
    // (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    public boolean compare (Box<?> another) {
        return Math.abs(this.getWeightBoxFruits() - another.getWeightBoxFruits()) < 0.0001;
    }

    // f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
    // (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
    // соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые
    // были в этой коробке;
    public void movingFruitFromBoxToBox(Box<T> another) {
        if (!this.boxFruits.isEmpty()) {
            another.boxFruits.addAll(this.boxFruits);
            this.boxFruits.clear();
        }
        else System.out.println("Первичная коробка пустая");
    }

}
