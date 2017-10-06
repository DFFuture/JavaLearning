package xml.imooc;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class SAX {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //1. 创建一个SAXParserFactory的对象
        SAXParserFactory sf = SAXParserFactory.newInstance();
        //2. 创建一个SAXParser的对象
        SAXParser sp = sf.newSAXParser();
        //3. 创建一个Handler
        SAXHandler handler = new SAXHandler();
        sp.parse("Resources/books.xml", handler);
        System.out.println("一共有" + handler.getBooks().size() + "本书");
    }
}

class SAXHandler extends DefaultHandler {
    private int bookIndex = 0;
    private String value = null;
    private Book book;
    private Class aClass;
    private ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    //开始解析元素
    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes) throws SAXException {
        //开始解析book元素
        if (qName.equals("book")) {
            book = new Book();
            books.add(book);
            aClass = book.getClass();
            bookIndex ++ ;
            //属性名已知
            book.setId(attributes.getValue("id"));
            System.out.println("属性id的属性值为：" + attributes.getValue("id"));
            //属性名未知
            for(int i = 0; i < attributes.getLength(); i++) {
                System.out.println("属性名：" + attributes.getQName(i));
                System.out.println("--属性值：" + attributes.getValue(i));
            }
        } else if (!qName.equals("bookstore")) {
            System.out.println("子节点：" + qName);
        }


    }

    //结束元素解析
    @Override
    public void endElement (String uri, String localName, String qName) throws SAXException {
        if(qName.equals("book")) {
            System.out.println("=====结束遍历第"+ bookIndex +"本书=====");
        }
        //利用反射获取子节点的值
        try {
            Field field = aClass.getDeclaredField(qName);
            field.setAccessible(true);
            field.set(book, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            //e.printStackTrace();
        }

//        switch(qName){
//            case "name": book.setName(value);break;
//            case "author": book.setAuthor(value);break;
//            case "year": book.setYear(value); break;
//            case "price": book.setPrice(value); break;
//            case "language": book.setLanguage(value);break;
//        }
    }

    //xml解析开始
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("XML解析开始！");
    }

    //xml解析结束
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("XML解析结束！");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch, start, length);
        if(!value.trim().equals(""))
            System.out.println("--节点内容：" + value);
    }
}
