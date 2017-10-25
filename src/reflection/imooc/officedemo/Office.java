package reflection.imooc.officedemo;

public class Office {
    public static void main(String[] args) {
        if("Word".equals(args[0])) {
            Word w = new Word();
            w.start();
        }
        if("Excel".equals(args[0])) {
            Excel e = new Excel();
            e.start();
        }
    }
}


/**
 * 如果Excel不存在，Word存在，及时只想使用Word,也无法运行Office
 */
class Excel {
    public  void start() {
        System.out.println("excel..starts");
    }
}