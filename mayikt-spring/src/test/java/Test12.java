import com.mayikt.service.MayiktService;
import com.mayikt.service.MayiktServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test12 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("user.xml");
        MayiktService mayiktService = classPathXmlApplicationContext.getBean("mayiktServiceImpl",MayiktService.class);
        mayiktService.addUser(20);
        System.out.println(mayiktService);
    }
}
