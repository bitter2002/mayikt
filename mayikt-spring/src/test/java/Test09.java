import com.mayikt.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test09 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        UserEntity userEntity1 = (UserEntity) classPathXmlApplicationContext.getBean("userEntity");
        UserEntity userEntity2 = (UserEntity) classPathXmlApplicationContext.getBean("userEntity");
        System.out.println(userEntity1);
        System.out.println(userEntity2);
        System.out.println(userEntity1==userEntity2);
    }
}
