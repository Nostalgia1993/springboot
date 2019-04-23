package com.example.config;

import com.example.annotation.OnConditionalAnnotation;
import org.springframework.context.annotation.Bean;

@OnConditionalAnnotation(system = "windows")
public class HelloWorld2 {

    static{
        System.out.println("hello world 22222 init...");
    }

    @Bean
    public HelloWorld2 helloWorld2(){
        System.out.println("初始化2222===========================");
        return new HelloWorld2();
    }
}
