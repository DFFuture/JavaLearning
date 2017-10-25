package annotation.imooc;

@Description(desc="I am a class", author = "Mooc")
public class Child implements Person {


    @Override
    @Description(desc="I am a method", author = "Mooc")
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {

    }
}
