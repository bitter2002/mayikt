import com.mayikt.entity.BookEntity;
import com.mayikt.entity.OrderEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
    public static void main(String[] args) {
        //1.加载到我们的spring配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("order.xml");
        //2.根据bean的id获取对象
        OrderEntity orderEntity = classPathXmlApplicationContext.getBean("orderEntity", OrderEntity.class);
        System.out.println(orderEntity);
    }
}
