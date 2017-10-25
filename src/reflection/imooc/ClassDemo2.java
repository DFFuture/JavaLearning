package reflection.imooc;

/**
 * Demo: 基本数据类型和类的类类型，类的全称和简称
 */
public class ClassDemo2 {
    public static void main(String[] args) {
        Class<Integer> intClass = int.class;  //int的类类型
        Class<Integer> integerClass = Integer.class; //Integer的类类型

        Class<String> strClass = String.class;  //String的类类型
        Class<Void> voidClass = void.class;  //void的类类型
        Class c = int[].class;

        System.out.println(intClass == integerClass);  //false

        //类的全称（包含包名）,基本类型只打印出基本类型名称
        System.out.println(intClass.getName());     //int
        System.out.println(integerClass.getName()); //java.lang.Integer
        System.out.println(voidClass.getName());    //void
        System.out.println(c.getName()); //[I  [:表示数组, I:表示int类型

        //类的简称（不包含包名）
        System.out.println(intClass.getSimpleName());      //int
        System.out.println(integerClass.getSimpleName());  //Integer
        System.out.println(voidClass.getSimpleName());     //void

    }
}
