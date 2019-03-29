package com.haku;

import com.baizhi.service.HelloService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-dubbo-consumer.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        String yangnb = helloService.sayHello("yangnb");
        System.out.println(yangnb);

    }
}
