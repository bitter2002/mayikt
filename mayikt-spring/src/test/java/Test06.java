
import com.mayikt.entity.EmEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("Em2.xml");
        EmEntity emEntity = (EmEntity) app.getBean("emEntity");
        System.out.println(emEntity);
    }
}