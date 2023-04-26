package com.mayikt.factory;

import com.mayikt.entity.UserEntity;
import com.mayikt.utils.Dom4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class UserFactory {
    public static UserEntity getUserEntity() throws ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
         /*
        * 1.使用解析xml技术 解析spring.xml配置文件；dom4J
        2.获取<bean id=”” class=””/> 类的完整路径地址
        3.使用到反射技术初始化对象
        4.需要使用工厂模式封装初始化对象
        * */
        //1.使用解析xml技术 解析spring.xml配置文件；dom4J
        String userClass = new Dom4j().getUserClass();
        //3.使用到反射技术初始化对象
        Class<?> aClass = Class.forName(userClass);
        //默认执行无参构造函数
        UserEntity userEntity = (UserEntity) aClass.newInstance();
        return userEntity;
    }
}
