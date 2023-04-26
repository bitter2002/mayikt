import com.mayikt.entity.EmEntity;
import com.mayikt.entity.StuEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("stu2.xml");
        StuEntity stuEntity = (StuEntity) app.getBean("stuEntity");
        System.out.println(stuEntity);
    }
}
