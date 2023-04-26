import com.mayikt.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
//        new UserEntity().addUser();

        //spring配置bean容器注入  注解或者xml方式
        //bean实际就是一个对象

        //1.加载到我们的spring配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //2.根据bean的id获取对象
        UserEntity userEntity = classPathXmlApplicationContext.getBean("userEntity", UserEntity.class);
        System.out.println(userEntity);
        userEntity.addUser();
    }
}
