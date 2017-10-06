package xml.imooc;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.*;
import java.util.List;

public class JDOM {
    public static void main(String[] args) {
        //1. 创建SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        try  {
            //2. 创建一个输入流
            InputStream in = new FileInputStream("Resources/books.xml");
            //设置编码
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            //3. 输入流加载到saxBuilder中
            Document document = saxBuilder.build(isr);
            //4. 通过Document对象获取xml文件的根节点
            Element root = document.getRootElement();
            //5. 获取根节点下的子节点
            List<Element> bookList = root.getChildren();
            for(Element book: bookList) {
                System.out.println("开始查看第" + bookList.indexOf(book) + "本书");
                System.out.println("属性id的属性值：" + book.getAttribute("id").getValue());
                //子节点
                for(Element child: book.getChildren()) {
                    System.out.println(child.getName() + ":" + child.getValue());
                }

            }
        } catch (IOException | JDOMException  e) {
            e.printStackTrace();
        }
    }
}
