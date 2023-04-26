import com.mayikt.entity.StuEntity;
import com.mayikt.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("mayiktBean.xml");
        UserEntity userEntity =(UserEntity) app.getBean("mayktBean");
        System.out.println(userEntity);
    }
}
