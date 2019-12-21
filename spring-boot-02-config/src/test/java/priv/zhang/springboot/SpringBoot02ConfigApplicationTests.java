package priv.zhang.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import priv.zhang.springboot.bean.Emp;
import priv.zhang.springboot.service.EmpService;

@SpringBootTest
class SpringBoot02ConfigApplicationTests {

    @Autowired
    Emp emp;

    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {
        System.out.println(emp);
    }

    @Test
    void testXml() {
//        EmpService service = (EmpService)context.getBean("empService");
//        service.add();
        EmpService service2 = (EmpService) context.getBean("empService2");
        service2.add();
    }

}
