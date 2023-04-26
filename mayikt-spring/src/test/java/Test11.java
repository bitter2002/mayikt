import com.mayikt.entity.EmEntity;
import com.mayikt.entity.MemberEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test11 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Em3.xml");
        EmEntity emEntity = classPathXmlApplicationContext.getBean("emEntity",EmEntity.class);
        System.out.println(emEntity);
        //手动让bean销毁
        classPathXmlApplicationContext.close();
    }
}
