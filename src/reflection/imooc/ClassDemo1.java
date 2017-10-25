package reflection.imooc;

/**
 * Demo：获取类类型，通过类类型创建类的对象
 */
public class ClassDemo1 {
    public static void main(String[] args) {
        Foo foo1 = new Foo();
        // 任何一个类都是Class的实例对象,该实例对象称为类的类类型（class type）,有三种表示方式
        // 1) 任何一个类都有一个隐含的静态成员变量class
        Class<Foo> c1 = Foo.class;

        // 2) 已知实例对象，通过getClass方法
        Class c2 = foo1.getClass();

        // c1,c2就是Foo的类类型
        System.out.println(c1 == c2);  //true

        //3) 通过Class.forName()
        Class c3 = null;
        try {
            c3 = Class.forName("reflection.imooc.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c2 == c3);  //true

        // 通过类类型创建类的对象
        try {
            Foo foo2 = (Foo)c1.newInstance();  //需要有无参数的构造方法
            foo2.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}

class Foo{

    void print() {
        System.out.println("foo");
    }
}
