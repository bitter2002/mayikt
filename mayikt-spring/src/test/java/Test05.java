import com.mayikt.dao.MemberDao;
import com.mayikt.service.MemberService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("Member.xml");
        MemberService memberService = (MemberService) app.getBean("memberService");
        memberService.addMember();
    }
}
