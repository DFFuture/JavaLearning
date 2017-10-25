package annotation.imooc;

import java.lang.reflect.Method;

public class ParseAnn {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("annotation.imooc.Description");
            boolean isExist = c.isAnnotationPresent(Description.class);
            if(isExist) {
                Description d = (Description) c.getAnnotation(Description.class);

                Method[] ms = c.getMethods();
                for(Method m: ms) {

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
