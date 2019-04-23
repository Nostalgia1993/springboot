package com.example.annotation;

import com.example.config.HelloWorldSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.TYPE})
@Import({HelloWorldSelector.class})
public @interface SelectAnnotation {
    boolean isLinux() default false;
}
