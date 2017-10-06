package xml.imooc;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * DOM解析XML示例
 */
public class Dom {
    public static void main(String[] args) {
        //创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {
            //创建一个DocumentBuilder的对象
            DocumentBuilder db = dbf.newDocumentBuilder();
            //通过parse方法获取Document的对象
            Document document = db.parse("Resources/books.xml");
            //根据标签名获取节点
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("一共有" + bookList.getLength() + "本书");
            //遍历节点
            for(int i = 0; i < bookList.getLength(); i++) {
                Node book = bookList.item(i);
                //获取节点属性
                NamedNodeMap attrs = book.getAttributes();
                //遍历属性
                for(int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    System.out.println("属性值：" + attr.getNodeName());
                    System.out.println("--属性值：" + attr.getNodeValue());
                }

                //已知属性名获取对应的属性值
                Element element = (Element) bookList.item(i);
                String attrValue = element.getAttribute("id");
                System.out.println("id属性的属性值为" + attrValue);

                //获取子节点
                NodeList children = book.getChildNodes();
                System.out.println("一共有" + children.getLength() + "子节点");
                for(int k = 0; k < children.getLength(); k++){
                    if(children.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        //节点名
                        System.out.print(children.item(k).getNodeName() + ": ");
                        //节点值
                        System.out.println(children.item(k).getFirstChild().getNodeValue());
                        //获取节点内的文本内容
                        System.out.println(children.item(k).getTextContent());
                    }
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
