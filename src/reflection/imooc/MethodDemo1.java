package reflection.imooc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Demo：通过反射调用方法
 */
public class MethodDemo1 {

    public static void main(String[] args) {
        A a1 = new A();
        Class c = a1.getClass();
        try {
            Method m1 = c.getMethod("print", new Class[]{int.class, int.class});
            m1.invoke(a1, 1, 2);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Method m2 = c.getMethod("print", String.class, String.class);
            m2.invoke(a1, "hello ", "World");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print(int a, int b) {
        System.out.println(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toUpperCase());
    }
}
