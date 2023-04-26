package com.mayikt.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class Dom4j {
    public String getUserClass() throws DocumentException {
        File xmlFile = new File(this.getClass().getResource("/").getPath() + "spring.xml");
        //new saxReader
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(xmlFile);
        //获取到根节点
        Element rootElement = document.getRootElement();
        Element bean = rootElement.element("bean");
        String aClass = bean.attributeValue("class");
        return aClass;
    }
}
