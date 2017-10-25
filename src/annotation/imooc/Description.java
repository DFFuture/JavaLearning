package annotation.imooc;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {

    //String desc(int a)   //要无参
    //String desc() throws Exception //要无异常
    String desc();

    String author();

    int age() default 18;
}
