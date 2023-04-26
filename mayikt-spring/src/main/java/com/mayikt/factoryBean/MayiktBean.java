package com.mayikt.factoryBean;

import com.mayikt.entity.UserEntity;
import org.springframework.beans.factory.FactoryBean;

public class MayiktBean implements FactoryBean {
    /*
    * 定义factoryBean的返回类型
    * */
    @Override
    public Object getObject() throws Exception {
        return new UserEntity();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
