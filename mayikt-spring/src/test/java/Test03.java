import com.mayikt.entity.BookEntity;
import com.mayikt.entity.UserEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
    public static void main(String[] args) {
        //1.加载到我们的spring配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("book.xml");
        //2.根据bean的id获取对象
        BookEntity bookEntity = classPathXmlApplicationContext.getBean("bookEntity3", BookEntity.class);
        System.out.println(bookEntity);

    }
}
