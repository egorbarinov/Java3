package Lesson_7.hw;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class HWCheck {
    public static void check() throws Exception {
        File file = new File("C:\\source\\Java3\\target\\classes\\Lesson_6\\hw");
        String[] str = file.list();

        for (String o : str) {
            String[] mass = o.split("\\.");
            if (!mass[1].equalsIgnoreCase("class")) {
                throw new RuntimeException(o, new Exception());
            }

            Class ch = URLClassLoader.newInstance(new URL[]
                    {new File("C:\\source\\Java3\\target\\classes").toURL()}).loadClass("ArrFoundFour");
            Constructor constructor =  ch.getConstructor(int[].class);
           Object aff  = (Object) constructor.newInstance(new int[]{1, 2, 3, 4, 5, 6, 7, 8}); // Exception in thread "main" java.lang.NoSuchMethodException: ArrFoundFour.<init>([I)
        Method m = ch.getDeclaredMethod("arrFoundFour");
        m.invoke(aff);
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\source\\Java3\\target\\classes\\");
        String[] str = file.list();
        for(String o : str){
            System.out.println(o);
        }
        check();
    }
}
