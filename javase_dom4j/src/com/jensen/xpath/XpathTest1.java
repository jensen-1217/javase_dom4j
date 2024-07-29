package com.jensen.xpath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class  XpathTest1 {

    @Test
    public void test4() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read("src/Contact.xml");

        //路径表达式（绝对路径）
        String path="//contact[@id=2]";
        //根据路径表达式，去xml文档中检查符合路径的所有元素
        List<Node> nodeList = doc.selectNodes(path);

        for (Node node : nodeList) {
            Element element = (Element) node;
            String id = element.attributeValue("id");
            System.out.println("id="+id);

            Element name = element.element("name");
            System.out.println(name.getText());
        }
    }

    @Test
    public void test3() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read("src/Contact.xml");

        //路径表达式（绝对路径）
        String path="//name";
        //根据路径表达式，去xml文档中检查符合路径的所有元素
        List<Node> nodeList = doc.selectNodes(path);

        for (Node node : nodeList) {
            String text = node.getText();
            System.out.println(text);
        }
    }

    @Test
    public void test2() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read("src/Contact.xml");

        //路径表达式（绝对路径）
        String path="/contactList/contact";
        //根据路径表达式，去xml文档中检查符合路径的所有元素
        List<Node> nodeList = doc.selectNodes(path);

        for (Node node : nodeList) {
           path="./name";

            Node node1 = node.selectSingleNode(path);

            System.out.println(node1.getText());
        }
    }

    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read("src/Contact.xml");

        //路径表达式（绝对路径）
        String path="/contactList/contact/name";
        //根据路径表达式，去xml文档中检查符合路径的所有元素
        List<Node> nodeList = doc.selectNodes(path);

        for (Node node : nodeList) {
            String text = node.getText();
            System.out.println(text);
        }
    }
}
