import com.mayikt.entity.UserEntity;
import com.mayikt.factory.UserFactory;
import org.dom4j.DocumentException;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, DocumentException {
    /*
    * 1.使用解析xml技术 解析spring.xml配置文件；dom4J
    2.获取<bean id=”” class=””/> 类的完整路径地址
    3.使用到反射技术初始化对象
    4.需要使用工厂模式封装初始化对象
    * */

//        Class<?> aClass = Class.forName("com.mayikt.entity.UserEntity");
//        //默认执行无参构造函数
//        UserEntity userEntity = (UserEntity)aClass.newInstance();
//        System.out.println(userEntity);
//        userEntity.addUser();
        UserEntity userEntity = UserFactory.getUserEntity();
        userEntity.addUser();
    }
}
