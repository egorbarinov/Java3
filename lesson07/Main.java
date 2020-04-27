package Lesson_7.hw;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestsClass tests = new TestsClass();
        start(tests);
    }

    private static void start(TestsClass tests) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = tests.getClass().getDeclaredMethods();
        ArrayList<Method> annotatedMethod = new ArrayList<>();

        // добавляем методы с аннотацией @Test в ArrayList
        for (Method o : methods) {
            if (o.isAnnotationPresent(Test.class)) {
                annotatedMethod.add(o);
            }
        }

        // Добавляем сортировку по приоритету
        Collections.sort(annotatedMethod, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(Lesson_7.hw.Test.class).priority() - o2.getAnnotation(Lesson_7.hw.Test.class).priority();
            }
        });

        // Проверяем на количество аннотаций @BeforeSuite и @AfterSuite,
        // бросаем Exceptions в случае, если их больше двух
        //добавляем аннотации @BeforeSuite и @AfterSuite в ArrayList на 0 и последний места соответственно
        for (Method o: methods) {
            if (o.isAnnotationPresent(Lesson_7.hw.BeforeSuite.class)){
                if (!annotatedMethod.get(0).isAnnotationPresent(BeforeSuite.class)){
                    annotatedMethod.add(0, o);
                } else throw new RuntimeException("Аннотациий BeforeSuite больше 1");

            } else if (o.isAnnotationPresent(Lesson_7.hw.AfterSuite.class)){
                if (!annotatedMethod.get(annotatedMethod.size()-1).isAnnotationPresent(AfterSuite.class)){
                    annotatedMethod.add(o);
                } else throw new RuntimeException("Аннотациий AfterSuite больше 1");
            }
        }

        for (Method o: annotatedMethod) {
            o.invoke(tests);
        }
    }
}
