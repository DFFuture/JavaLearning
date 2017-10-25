package reflection.imooc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassUtil {

    /**
     * 打印类的信息
     * @param object
     */
    public static void printClassMessage(Object object) {
        Class c = object.getClass();
        //获取类的名称
        System.out.println("类的名称：" + c.getName());
        //获取成员方法
        //获取public方法，包括从父类继承的方法
        Method[] ms = c.getMethods();
        //获取类自己声明的所有方法，但不包括继承的
        Method[] dms = c.getDeclaredMethods();

        for(Method m: dms) {
            //方法返回类型
            Class returnType = m.getReturnType();
            System.out.println("方法返回的类型：" + returnType.getName());
            //方法名称
            System.out.print("方法：" + m.getName() + "(");
            Class[] paramTypes = m.getParameterTypes();
            for(int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getName());
                if(i != paramTypes.length - 1)
                    System.out.print(" ,");
            }
            System.out.println(")");
        }
    }

    public static void printFieldMessage(Object object) {
        Class c = object.getClass();
        //获取成员变量
        Field[] fs = c.getFields();
        Field[] dfs = c.getDeclaredFields();
        for(Field df: dfs) {
            //成员变量类型
            Class fieldType = df.getType();
            String typeName = fieldType.getName();
            //成员变量名称
            String fieldName = df.getName();
            System.out.println(typeName + " " + fieldName);
        }
    }

    /**
     * 打印构造函数的信息
     * @param obj
     */
    public static void printConMessage(Object obj) {
        Class c = obj.getClass();
        Constructor[] cs = c.getConstructors();
        Constructor[] dcs = c.getDeclaredConstructors();
        for(Constructor dc : dcs) {
            System.out.print(dc.getName()+"(");
            Class[] paramTypes = dc.getParameterTypes();
            for(int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getName());
                if(i != paramTypes.length - 1)
                    System.out.print(" ,");
            }
            System.out.println(")");
        }

    }

}
