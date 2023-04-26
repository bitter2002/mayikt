package com.mayikt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.mayikt.controller")
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {
    /**
     * 1.@Configuration  定义SpringMVCConfig.xml配置文件
     * 2.需要将我们的控制类注入到ioc容器 @ComponentScan("com.mayikt.controller")
     * @ComponentScan("com.mayikt.controller")将该包下所有的类 注入到IOC容器种
     * 3.在springmvc原理 所有请求过来先达到我们的 DispatcherServlet 分发具体控制类 方法执行
     *
     *
     *    @Configuration
     *     SpringMVCConfig.java   @Configuration
     *     springmvc.xml=== SpringMVCConfig.java
     *     -->
     */

    //WebMvcConfigurer
    @Bean
    public InternalResourceViewResolver resourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        //请求视图文件的前缀地址
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        //请求视图文件的后缀
        internalResourceViewResolver.setSuffix(".jsp");

        internalResourceViewResolver.setExposeContextBeansAsAttributes(true);
        return internalResourceViewResolver;
    }

    /**
     * 视图配置
     *
     * @param registry
     */
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(resourceViewResolver());
    }
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
