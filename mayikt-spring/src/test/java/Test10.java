import com.mayikt.entity.MemberEntity;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test10 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Member02.xml");
        MemberEntity memberEntity = classPathXmlApplicationContext.getBean("memberEntity",MemberEntity.class);
        System.out.println("[第四步]:获取使用到memberEntity");
        System.out.println(memberEntity);
        //手动让bean销毁
        classPathXmlApplicationContext.close();
    }
}
