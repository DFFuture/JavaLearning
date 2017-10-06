package xml.imooc;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.Iterator;
import java.util.List;

public class DOM4J {
    public static void main(String[] args) {
        //创建SAXReader对象
        SAXReader saxReader = new SAXReader();
        try {
            //加载XML文件，获取Document对象
            Document document = saxReader.read("Resources/books.xml");
            //获取根节点
            Element root = document.getRootElement();
            //获取迭代器
            Iterator<Element> iterator = root.elementIterator();
            while(iterator.hasNext()) {
                Element book = iterator.next();
                List<Attribute> attrs = book.attributes();
                for(Attribute attr: attrs) {
                    System.out.println(attr.getName() + ":" + attr.getValue());
                }
                for(Element child: book.elements()) {
                    System.out.println(child.getName() + ":" + child.getStringValue());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
