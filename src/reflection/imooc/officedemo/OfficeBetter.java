package reflection.imooc.officedemo;

/**
 * Demo: 反射的意义：动态加载类
 */
public class OfficeBetter {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("reflection.imooc." + args[0]);
            OfficeAble office = (OfficeAble)c.newInstance();
            office.start();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
