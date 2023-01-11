package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {

    @Test
    public void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);


    }

    public static class TestBean {

        @Autowired(required = false) // 호출 아예 안됨
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired // null 반환
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean1 = " + noBean2);
        }

        @Autowired // Optional.empty 반환
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean1 = " + noBean3);
        }
    }
}
