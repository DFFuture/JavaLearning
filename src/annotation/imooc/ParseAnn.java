package annotation.imooc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ParseAnn {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("annotation.imooc.Child");
            boolean isExist = c.isAnnotationPresent(Description.class);
            if(isExist) {
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.desc());

            }
            Method[] ms = c.getMethods();
            for(Method m: ms) {
                if(m.isAnnotationPresent(Description.class)) {
                    Description d = m.getAnnotation(Description.class);
                    System.out.println(d.desc());
                }
            }

            for(Method m: ms) {
                Annotation[] as = m.getAnnotations();
                for(Annotation a: as) {
                    if(a instanceof Description) {
                        Description d = (Description) a;
                        System.out.println(d.desc());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
