import Lesson_6.hw.ArrFoundFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestArrFoundFour {
    @Parameterized.Parameters
    public static Collection<Object[]> dataArr() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}}, // ok
                {new int[]{0, 2, 3, 0, 1, 7}, new int[]{1, 2, 4, 1, 2, 3, 0, 1, 7}}, // Массивы разные
                {new int[]{0, 2, 3, 3, 2, 5}, new int[]{1, 2, 0, 0, 2, 3, 3, 2, 5}},// Значение массива равное 4 отсутствует
                {new int[]{2, 3, 0, 1, 7}, new int[]{1, 2, 4, 4, 2, 3, 0, 1, 7}}, // ok
        });
    }
    private ArrFoundFour aff;
    private int[] a;
    private int[] b;

    public TestArrFoundFour(int[] a, int[] b){
        this.a = a;
        this.b = b;
    }

    @Before
    public void init(){
        aff = new ArrFoundFour();
    }

    @Test
    public void test() {
        Assert.assertTrue("Массивы разные", Arrays.equals(a, aff.arrFoundFour(b)));
    }
}
