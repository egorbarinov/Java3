import Lesson_6.hw.MyBoolean;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestMyBoolean {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {true, new int[]{1, 4, 3, 4, 4, 1, 1, 4, 1}},
                {true, new int[]{4, 4, 1, 1, 4, 2, 1, 1, 4}},
                {true, new int[]{1, 1, 1, 1, 1, 1, 1, 4, 4}},
                {true, new int[]{4, 4, 4, 4, 4, 4, 1, 1, 1}},
        });
    }

    private MyBoolean mb;
    boolean b;
    int[] arr;

    public TestMyBoolean(boolean b, int[] arr) {
        this.b = b;
        this.arr = arr;
    }
    @Before
    public void init(){
        mb = new MyBoolean();
    }

    @Test
    public void test(){
        Assert.assertEquals(b, mb.bool(arr));
    }
}
