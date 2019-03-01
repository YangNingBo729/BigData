package com.haku.quartz_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzTest2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_quartz.xml");
    }
}
