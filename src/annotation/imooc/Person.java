package annotation.imooc;


public interface Person {

    public String name();

    public int age();

    @Deprecated
    public void sing();
}
